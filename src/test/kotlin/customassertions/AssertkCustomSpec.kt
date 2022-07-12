package customassertions

import assertk.Assert
import assertk.assertThat
import assertk.assertions.support.expected
import assertk.assertions.support.show
import model.SomeObject
import org.junit.jupiter.api.Test

class AssertkCustomSpec {

    @Test
    fun `assertk - custom assertion`() {
        // given
        val actual = SomeObject(true, "tekst", listOf("a", "b"))

        // then
        assertThat(actual).hasStringProperty("inny tekst")
    }
}

fun Assert<SomeObject>.hasStringProperty(expected: String) = given { actual ->
    if (actual.stringProperty == expected) return
    expected("string property:${show(expected)} but was:${show(actual.stringProperty)}")
}
