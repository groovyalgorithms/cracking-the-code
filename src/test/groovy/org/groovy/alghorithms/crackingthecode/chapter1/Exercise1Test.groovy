package org.groovy.alghorithms.crackingthecode.chapter1

import spock.lang.Specification

/**
 * Created by daniele on 27/11/15.
 */
class Exercise1Test extends Specification {
    def "it should respond correctly to exercise 1 for every solution provided"() {
        expect:
        Exercise1Java.solution1a(input) == solution
        Exercise1Java.solution1b(input) == solution
        Exercise1Java.solution2(input) == solution

        Exercise1Groovy.solution1a(input) == solution
        Exercise1Groovy.solution1b(input) == solution
        Exercise1Groovy.solution2a(input) == solution
        Exercise1Groovy.solution2b(input) == solution

        where:
        input  | solution
        null   | false
        ""     | false
        "a"    | true
        "aa"   | false
        "ab"   | true
        "aab"  | false
        "aba"  | false
        "baa"  | false
        "abc"  | true
        "aaab" | false
    }
}
