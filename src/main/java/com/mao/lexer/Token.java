package com.mao.lexer;

import com.mao.common.AlphabetHelper;
import com.mao.common.PeekIterator;

public class Token {
    private TokenType type;
    private String value;

    public Token(TokenType type, String value) {
        this.type = type;
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

    /**
     * 提取变量或者关键字
     * @param it
     * @return
     */
    public static Token makeVarOrKeyword(PeekIterator<Character> it) {
        // 第一个字符总是匹配的
        String s = "";
        while (it.hasNext()) {
            Character lookahead = it.peek();
            if(AlphabetHelper.isLiteral(lookahead)) {
                s += lookahead;
            }else {
                break;
            }
            it.next();
            // 循环不变式
        }

        // 判断关键词 OR 变量
        if(Keywords.isKeyword(s)) {
            return new Token(TokenType.KEYWORD, s);
        }
        if("true".equals(s) || "false".equals(s)) {
            return new Token(TokenType.BOOLEAN, s);
        }
        return new Token(TokenType.VARIABLE, s);
    }
}
