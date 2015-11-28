package org.groovy.alghorithms.crackingthecode.chapter1

import groovy.transform.CompileStatic

class Exercise1Groovy {

    /**
     * Solution with Hashset: more efficient, it breaks at first repeating character
     */
    static Boolean solution1a(String input) {
        def set = [] as HashSet
        for (def character : input) {
            if (set.contains(character)) {
                return false
            }
            set << character
        }
        input as boolean
    }

    /**
     * Solution with Hashset: one-line implementation
     */
    static Boolean solution1b(String input) {
        input && (input.collect { it } as HashSet).size() == input.length()
    }

    /**
     * Solution without a Data Structure: one-instruction solution
     */
    static Boolean solution2a(String input) {
        input && input.every { character ->
            input.findAll { it == character }.size() == 1
        }
    }


    /**
     * Solution without a Data Structure: more efficient by breaking at first repeating character.
     * Extended String class to have a method that count occurrencies and breaks at first repeating character
     */
    static {
        String.metaClass.onlyOne = { Closure closure ->
            def count = 0
            for (def c : delegate) {
                if (closure(c) && ++count > 1) {
                    return false
                }
            }
            return true
        }
    }

    static Boolean solution2b(String input) {
        input && input.every { character ->
            input.onlyOne { it == character }
        }
    }

     static boolean solution2c(String input) {
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
