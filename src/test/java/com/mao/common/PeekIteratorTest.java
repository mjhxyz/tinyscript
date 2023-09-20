package com.mao.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeekIteratorTest {

    @Test
    public void peekTest() {
        String source = "abcdefg";
        PeekIterator<Character> it = new PeekIterator<>(source.chars().mapToObj(c -> (char) c));

        assertEquals('a', it.next().charValue());
        assertEquals('b', it.next().charValue());
        it.next();
        it.next();
        assertEquals('e', it.next().charValue());
        assertEquals('f', it.peek().charValue());
        assertEquals('f', it.peek().charValue());
        assertEquals('f', it.next().charValue());
        assertEquals('g', it.next().charValue());
    }

    @Test
    public void lookaheadTest() {
        String source = "abcdefg";
        PeekIterator<Character> it = new PeekIterator<>(source.chars().mapToObj(c -> (char) c));

        assertEquals('a', it.next().charValue());
        assertEquals('b', it.next().charValue());
        assertEquals('c', it.next().charValue());
        it.putBack();
        it.putBack();
        assertEquals('b', it.next().charValue());
    }

    @Test
    public void endTokenTest() {
        String source = "abcdefg";
        PeekIterator<Character> it = new PeekIterator<>(source.chars().mapToObj(c -> (char) c), (char)0);

        int i = 0;
        while (it.hasNext()) {
            if(i == 7) {
                assertEquals((char)0, it.next().charValue());
            }else {
                assertEquals(source.charAt(i++), it.next().charValue());
            }
        }
    }
}