package org.groovy.alghorithms.crackingthecode.chapter1;

import java.util.HashSet;

public class Exercise1Java {

    /**

     */
    public static boolean solution1a(String input) {
        HashSet<Character> letters = new HashSet<>();
        if (input != null) {
            for (char c : input.toCharArray()) {
                if (letters.contains(c)) {
                    return false;
                }
                letters.add(c);
            }
        }
        return input != null && input.length() > 0;
    }

    public static boolean solution1b(String input) {
        HashSet<Character> letters = new HashSet<>();
        if (input != null) {
            for (char c : input.toCharArray()) {
                letters.add(c);
            }
        }
        return input != null && input.length() > 0 && letters.size() == input.length();
    }

    public static boolean solution2(String input) {
        if (input != null) {
            for (int i = 0; i < input.length(); i++) {
                for (int j = 0; j < input.length(); j++) {
                    if (i != j && input.charAt(i) == input.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return input != null && input.length() > 0;
    }

}
