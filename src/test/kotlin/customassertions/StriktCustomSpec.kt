package customassertions

import model.SomeObject
import org.junit.jupiter.api.Test
import strikt.api.Assertion
import strikt.api.expectThat

class StriktCustomSpec {

    @Test
    fun `strikt - custom assertion`() {
        // given
        val actual = SomeObject(true, "tekst", listOf("a", "b"))

        // then
        expectThat(actual).hasStringProperty("inny tekst")
    }
}

fun Assertion.Builder<SomeObject>.hasStringProperty(expected: String): Assertion.Builder<SomeObject> {
    return assert("has string property: $expected") {
        if (it.stringProperty == expected) {
            pass()
        } else {
            fail(description = "in fact it is %s", actual = it.stringProperty)
        }
    }
}
