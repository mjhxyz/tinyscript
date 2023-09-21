package com.mao.lexer;

/**
 * @author mao
 * @date 2023/9/21 19:59
 */
public class LexicalException extends Exception{
    private String msg;

    public LexicalException(char c) {
        this(String.format("Unexpected character %c", c));
    }

    public LexicalException(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
