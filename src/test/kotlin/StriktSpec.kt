import model.SomeObject
import org.junit.jupiter.api.Test
import strikt.api.expect
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isFalse

class StriktSpec {

    @Test
    fun `strikt - compare properties`() {
        // given
        val actual = SomeObject(true, "tekst", listOf("a", "b"))

        // then
        expect {
            that(actual.booleanProperty).isFalse()
            that(actual.stringProperty).isEqualTo("inny tekst")
            that(actual.listProperty).isEqualTo(listOf("x", "y", "z"))
        }
    }

    @Test
    fun `strikt - compare objects`() {
        // given
        val expected = SomeObject(false, "inny tekst", listOf("x", "y", "z"))
        val actual = SomeObject(true, "tekst", listOf("a", "b"))

        // then
        expectThat(actual).isEqualTo(expected)
    }
}
