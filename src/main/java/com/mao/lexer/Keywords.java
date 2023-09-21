package com.mao.lexer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mao
 * @date 2023/9/21 20:36
 */
public class Keywords {
    static String[] keywords = {
            "var",
            "if",
            "else",
            "for",
            "while",
            "break",
            "func",
            "return"
    };

    static Set<String> set = new HashSet<>(Arrays.asList(keywords));

    public static boolean isKeyword(String word) {
        return set.contains(word);
    }
}
