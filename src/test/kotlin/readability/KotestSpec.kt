package readability

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.shouldBe
import model.SomeObject
import org.junit.jupiter.api.Test

class KotestSpec {

    @Test
    fun `kotest - compare properties`() {
        // given
        val actual = SomeObject(true, "tekst", listOf("a", "b"))

        // then
        assertSoftly {
            actual.booleanProperty.shouldBeFalse()
            actual.stringProperty.shouldBe("inny tekst")
            actual.listProperty.shouldBe(listOf("x", "y", "z"))
        }
    }

    @Test
    fun `kotest - compare objects`() {
        // given
        val expected = SomeObject(false, "inny tekst", listOf("x", "y", "z"))
        val actual = SomeObject(true, "tekst", listOf("a", "b"))

        // then
        actual shouldBe expected
    }
}
