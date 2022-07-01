import model.SomeObject
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test

class AssertJSpec {

    @Test
    fun `assertj - compare properties`() {
        // given
        val actual = SomeObject(true, "tekst", listOf("a", "b"))

        // then
        val softly = SoftAssertions()
        softly.assertThat(actual.booleanProperty).isFalse
        softly.assertThat(actual.stringProperty).isEqualTo("inny tekst")
        softly.assertThat(actual.listProperty).isEqualTo(listOf("x", "y", "z"))
        softly.assertAll()
    }

    @Test
    fun `assertj - compare objects`() {
        // given
        val expected = SomeObject(false, "inny tekst", listOf("x", "y", "z"))
        val actual = SomeObject(true, "tekst", listOf("a", "b"))

        // then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected)
    }
}
