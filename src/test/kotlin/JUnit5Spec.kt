import model.SomeObject
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class JUnit5Spec {

    @Test
    fun `junit5 - compare properties`() {
        // given
        val actual = SomeObject(true, "tekst", listOf("a", "b"))

        // then
        assertAll(
            { assertFalse(actual.booleanProperty) },
            { assertEquals(actual.stringProperty, "inny tekst") },
            { assertEquals(actual.listProperty, listOf("x", "y", "z")) }
        )
    }

    @Test
    fun `junit5 - compare objects`() {
        // given
        val expected = SomeObject(false, "inny tekst", listOf("x", "y", "z"))
        val actual = SomeObject(true, "tekst", listOf("a", "b"))

        // then
        assertSame(actual, expected)
    }
}
