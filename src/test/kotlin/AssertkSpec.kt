import assertk.assertAll
import assertk.assertThat
import assertk.assertions.isDataClassEqualTo
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import model.SomeObject
import org.junit.jupiter.api.Test

class AssertkSpec {

    @Test
    fun `assertk - compare properties`() {
        // given
        val actual = SomeObject(true, "tekst", listOf("a", "b"))

        // then
        assertAll {
            assertThat(actual::booleanProperty).isFalse()
            assertThat(actual::stringProperty).isEqualTo("inny tekst")
            assertThat(actual::listProperty).isEqualTo(listOf("x", "y", "z"))
        }
    }

    @Test
    fun `assertk - compare objects`() {
        // given
        val expected = SomeObject(false, "inny tekst", listOf("x", "y", "z"))
        val actual = SomeObject(true, "tekst", listOf("a", "b"))

        // then
        assertThat(actual).isDataClassEqualTo(expected)
    }
}
