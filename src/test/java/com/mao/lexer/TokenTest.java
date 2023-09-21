package com.mao.lexer;

import com.mao.common.PeekIterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author mao
 * @date 2023/9/21 20:39
 */
public class TokenTest {

    private void assertToken(Token token, String value, TokenType type) {
        assertEquals(type, token.getType());
        assertEquals(value, token.getValue());
    }
    @Test
    public void varOrKeywordTest() {
        PeekIterator<Character> it1 = new PeekIterator<>("if abc".chars().mapToObj(x -> (char) x));
        PeekIterator<Character> it2 = new PeekIterator<>("true abc".chars().mapToObj(x -> (char) x));

        Token token1 = Token.makeVarOrKeyword(it1);
        Token token2 = Token.makeVarOrKeyword(it2);


        assertToken(token1, "if", TokenType.KEYWORD);
        assertToken(token2, "true", TokenType.BOOLEAN);

        it1.next(); // 忽略空格

        Token token3 = Token.makeVarOrKeyword(it1);

        assertToken(token3, "abc", TokenType.VARIABLE);
    }
}
