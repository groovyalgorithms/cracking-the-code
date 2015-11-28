import org.apache.commons.lang3.RandomStringUtils
import org.groovy.alghorithms.crackingthecode.chapter1.Exercise1Groovy
import org.groovy.alghorithms.crackingthecode.chapter1.Exercise1Java

def solutions = [
        (Exercise1Groovy) : ['solution1a', 'solution1b', 'solution2a', 'solution2c'],
        (Exercise1Java) : ['solution1', 'solution2'],
]
def r = benchmark {   // or new groovyx.gbench.BenchmarkBuilder().run {
    solutions.each { clazz, methods ->
        methods.each { method ->
            [10, 20, 40, 80].each { n ->
                def inputs = (1..100).collect { RandomStringUtils.random(n) }
                "${clazz.getSimpleName()} $method" {
                    inputs.each { input ->
                        clazz."$method"(input)
                    }
                }
            }
        }
    }
}
r.prettyPrint()

