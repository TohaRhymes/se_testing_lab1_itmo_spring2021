import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.CsvSource
import kotlin.math.atan
import tohaMath.genius_arctg

class geniusArctgTest {
    @ParameterizedTest
    @CsvSource(
        "-1.0, 0.01",
    )
    fun testLeftBorder(x: Double, eps: Double) {
        Assertions.assertEquals(atan(x), genius_arctg(x, eps), eps)
    }


    @ParameterizedTest
    @CsvSource(
        "-0.33, 0.01",
    )
    fun testStrange(x: Double, eps: Double) {
        Assertions.assertEquals(atan(x), genius_arctg(x, eps), eps)
    }


    @ParameterizedTest
    @CsvSource(
        "1.0, 0.01",
    )
    fun testRightBorder(x: Double, eps: Double) {
        Assertions.assertEquals(atan(x), genius_arctg(x, eps), eps)
    }

    @ParameterizedTest
    @CsvSource(
        "0.0, 0.01",
    )
    fun testCenter(x: Double, eps: Double) {
        Assertions.assertEquals(atan(x), genius_arctg(x, eps), eps)
    }


    // Зафейлится
    @ParameterizedTest
    @CsvSource(
        "1000, 0.01",
    )
    fun FailRightBorder(x: Double, eps: Double) {
        Assertions.assertEquals(atan(x), genius_arctg(x, eps), eps)
    }
}