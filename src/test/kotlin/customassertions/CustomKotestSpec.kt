package customassertions

import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.should
import io.kotest.matchers.shouldNot
import model.SomeObject
import org.junit.jupiter.api.Test

class CustomKotestSpec {

    @Test
    fun `kotest - custom assertion`() {
        // given
        val actual = SomeObject(true, "tekst", listOf("a", "b"))

        // then
        actual shouldHaveStringProperty "inny tekst"
    }
}

fun hasStringProperty(expected: String) = Matcher<SomeObject> {
    return@Matcher MatcherResult(
        it.stringProperty == expected,
        { "string property was ${it.stringProperty} but we expected $expected" },
        { "some object string property should not be $expected" },

        )
}

infix fun SomeObject.shouldHaveStringProperty(expected: String): SomeObject {
    this should hasStringProperty(expected)
    return this
}

infix fun SomeObject.shouldNotHaveStringProperty(expected: String): SomeObject {
    this shouldNot hasStringProperty(expected)
    return this
}
