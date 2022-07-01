import model.SomeObject
import org.assertj.core.api.AbstractAssert
import org.junit.jupiter.api.Test

class CustomAssertJSpec {

    @Test
    fun `assertj - custom assertion`() {
        // given
        val actual = SomeObject(true, "tekst", listOf("a", "b"))

        // then
        assertThat(actual).hasStringProperty("inny tekst")
    }
}

class SomeObjectAssert(actual: SomeObject?) :
    AbstractAssert<SomeObjectAssert, SomeObject?>(actual, SomeObjectAssert::class.java) {

    fun hasStringProperty(stringProperty: String): SomeObjectAssert {
        isNotNull
        if (actual?.stringProperty != stringProperty) {
            failWithMessage(
                "Expected string property to be %s but was %s",
                stringProperty, actual?.stringProperty
            )
        }
        return this
    }
}

fun assertThat(actual: SomeObject): SomeObjectAssert = SomeObjectAssert(actual)
