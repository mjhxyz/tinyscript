package com.mao.common;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Stream;

public class PeekIterator<T> implements Iterator<T> {
    private Iterator<T> it;
    private LinkedList<T> queueCache = new LinkedList<>(); // 缓存最近 10 个
    private LinkedList<T> stackPutBacks = new LinkedList<>(); // 用来 peek
    private T endToken = null;
    private static int CACHE_SIZE = 10;
    public PeekIterator(Stream<T> stream) {
        this.it = stream.iterator();
    }
    public PeekIterator(Stream<T> stream, T endToken) {
        this.it = stream.iterator();
        this.endToken = endToken;
    }

    public T peek() {
        if(!this.stackPutBacks.isEmpty()) {
            // stack 有值时，直接用 getFirst 保证 peek 操作
            return this.stackPutBacks.getFirst(); // 拿出来，不取出来
        }
        if(!it.hasNext()) {
            return endToken;
        }
        // stack 没有，则从 iterator 获取
        // 然后 putBack 回去
        T val = next();
        this.putBack();
        return val;
    }

    // 缓存 A -> B -> C -> D
    // 放回 D -> C -> B -> A
    public void putBack() {
        if(this.queueCache.size() > 0) {
            // 队列导入到栈里
            stackPutBacks.push(this.queueCache.pollLast());
        }
    }

    @Override
    public boolean hasNext() {
        return !this.stackPutBacks.isEmpty() || it.hasNext();
    }

    @Override
    public T next() {
        T val = null;
        // 获取下一个元素，要先尝试从 stack 中获取
        // 再从 iterator 获取
        if(this.stackPutBacks.size() > 0) {
            val = this.stackPutBacks.pop();
        }else{
            if(!this.it.hasNext()) {
                return endToken;
            }
            val = it.next();
        }
        while (queueCache.size() > CACHE_SIZE - 1) { // 控制缓存大小
            queueCache.poll();
        }
        queueCache.add(val);
        return val;
    }
}
