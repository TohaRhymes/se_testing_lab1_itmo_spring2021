import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import tohaAlgo.BucketSort
import java.util.*


class geniusSortTest() {

    private val underTest = BucketSort()

    @Test
    fun testDescPosNegArraySort() {
        val A = longArrayOf(5, 1, 0, -1, -5)
        underTest.sort(A)
        Assertions.assertTrue(A.sortedArray() contentEquals underTest.res)
        // intermidiate
        // [[-5], [], [0, -1], [1], [5]]
        Assertions.assertEquals(underTest.intermed_res?.get(0)?.size, 1)
        Assertions.assertEquals(underTest.intermed_res?.get(0)?.get(0), -5)
        Assertions.assertEquals(underTest.intermed_res?.get(1)?.size, 0)
        Assertions.assertEquals(underTest.intermed_res?.get(2)?.size, 2)
        Assertions.assertEquals(underTest.intermed_res?.get(2)?.get(0), 0)
        Assertions.assertEquals(underTest.intermed_res?.get(2)?.get(1), -1)
        Assertions.assertEquals(underTest.intermed_res?.get(3)?.size, 1)
        Assertions.assertEquals(underTest.intermed_res?.get(3)?.get(0), 1)
        Assertions.assertEquals(underTest.intermed_res?.get(4)?.size, 1)
        Assertions.assertEquals(underTest.intermed_res?.get(4)?.get(0), 5)
    }


    @Test
    fun testAscNegArraySort() {
        //[[-5], [], [-1, 0], [1], [5]]
        val A = longArrayOf(-5, -1, 0, 1, 5)
        underTest.sort(A)
        Assertions.assertTrue(A.sortedArray() contentEquals underTest.res)
        Assertions.assertEquals(underTest.intermed_res?.get(0)?.size, 1)
        Assertions.assertEquals(underTest.intermed_res?.get(0)?.get(0), -5)
        Assertions.assertEquals(underTest.intermed_res?.get(1)?.size, 0)
        Assertions.assertEquals(underTest.intermed_res?.get(2)?.size, 2)
        Assertions.assertEquals(underTest.intermed_res?.get(2)?.get(0), -1)
        Assertions.assertEquals(underTest.intermed_res?.get(2)?.get(1), 0)
        Assertions.assertEquals(underTest.intermed_res?.get(3)?.size, 1)
        Assertions.assertEquals(underTest.intermed_res?.get(3)?.get(0), 1)
        Assertions.assertEquals(underTest.intermed_res?.get(4)?.size, 1)
        Assertions.assertEquals(underTest.intermed_res?.get(4)?.get(0), 5)
    }


}