package com.mao.common;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author mao
 * @date 2023/9/21 20:06
 */
public class AlphabetHelperTest {

    @Test
    public void isLetter() {
        assertTrue(AlphabetHelper.isLetter('a'));
        assertTrue(AlphabetHelper.isLetter('c'));
        assertTrue(AlphabetHelper.isLetter('I'));
        assertTrue(AlphabetHelper.isLetter('Q'));
        assertFalse(AlphabetHelper.isLetter('9'));
        assertFalse(AlphabetHelper.isLetter('8'));
        assertFalse(AlphabetHelper.isLetter('*'));
        assertFalse(AlphabetHelper.isLetter('/'));
        assertFalse(AlphabetHelper.isLetter('('));
        assertFalse(AlphabetHelper.isLetter('_'));

        assertTrue(AlphabetHelper.isNumber('9'));
        assertTrue(AlphabetHelper.isNumber('8'));
        assertTrue(AlphabetHelper.isNumber('7'));
        assertTrue(AlphabetHelper.isNumber('4'));
        assertFalse(AlphabetHelper.isNumber('*'));
        assertFalse(AlphabetHelper.isNumber('&'));
        assertFalse(AlphabetHelper.isNumber('^'));
        assertFalse(AlphabetHelper.isNumber('+'));
        assertFalse(AlphabetHelper.isNumber('/'));
        assertFalse(AlphabetHelper.isNumber('='));

        assertTrue(AlphabetHelper.isLiteral('a'));
        assertTrue(AlphabetHelper.isLiteral('c'));
        assertTrue(AlphabetHelper.isLiteral('I'));
        assertTrue(AlphabetHelper.isLiteral('Q'));
        assertTrue(AlphabetHelper.isLiteral('_'));
        assertTrue(AlphabetHelper.isLiteral('9'));
        assertTrue(AlphabetHelper.isLiteral('8'));
        assertFalse(AlphabetHelper.isLiteral('*'));
        assertFalse(AlphabetHelper.isLiteral('/'));
        assertFalse(AlphabetHelper.isLiteral('('));

        assertTrue(AlphabetHelper.isOperator('+'));
        assertTrue(AlphabetHelper.isOperator('-'));
        assertTrue(AlphabetHelper.isOperator('*'));
        assertTrue(AlphabetHelper.isOperator('/'));
        assertTrue(AlphabetHelper.isOperator('&'));
        assertFalse(AlphabetHelper.isOperator('a'));
        assertFalse(AlphabetHelper.isOperator('8'));
        assertFalse(AlphabetHelper.isOperator('9'));
        assertFalse(AlphabetHelper.isOperator('0'));
        assertFalse(AlphabetHelper.isOperator('?'));
        assertFalse(AlphabetHelper.isOperator('_'));
    }
}