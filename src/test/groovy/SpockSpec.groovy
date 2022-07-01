import model.SomeObject
import spock.lang.Specification

class SpockSpec extends Specification {

    def "spock - compare properties"() {
        when:
        def actual = new SomeObject(true, "tekst", ["a", "b"])

        then:
        verifyAll(actual) {
            !it.booleanProperty
            it.stringProperty == "inny tekst"
            it.listProperty == ["x", "y", "z"]
        }
    }

    def "spock - compare objects"() {
        when:
        def expected = new SomeObject(false, "inny tekst", ["x", "y", "z"])
        def actual = new SomeObject(true, "tekst", ["a", "b"])

        then:
        actual == expected
    }
}
