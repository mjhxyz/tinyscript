package com.mao.lexer;

public class Token {
    private TokenType type;
    private String value;

    public Token(TokenType type, String value) {
        this.value = value;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }

    public boolean isVariable() {
        return type == TokenType.VARIABLE;
    }

    public boolean isScalar() {
        return type == TokenType.INTEGER || type == TokenType.FLOAT || type == TokenType.STRING || type == TokenType.BOOLEAN;
    }
}
