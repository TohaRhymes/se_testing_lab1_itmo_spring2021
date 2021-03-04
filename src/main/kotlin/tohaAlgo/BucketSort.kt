package tohaAlgo


import java.util.LinkedList
import kotlin.math.abs
import kotlin.math.floor

public class BucketSort{

    lateinit var res :LongArray
    var intermed_res : Array<LinkedList<Long>>? = null

    public fun sort(array: LongArray) {
        val arr = array.toList().toTypedArray()
        val minArrayValue = arr.minOrNull()
        val maxArrayValue = arr.maxOrNull()
        val range = minArrayValue?.let { maxArrayValue?.minus(it) } // max - min
        //Number of buckets can depend on input array size
        val numberOfBuckets = if (arr.size > 100) floor(arr.size / 10.0).toInt() else arr.size
        val outputArray = arr
        val sortArray = Array<LinkedList<Long>>(numberOfBuckets) { _ -> LinkedList() } //We need to store digits in range 0..9
        for (element in arr){
            var valueIndex = (((element - minArrayValue!!)* numberOfBuckets)/ range!!).toInt() // It's a number in range 0..9
            if (valueIndex == arr.size){
                valueIndex = arr.size - 1 //Maximum values go to the last bucket
            }
            sortArray[valueIndex].add(element)
        }
        var outputArrayIndex = 0
        for (list in sortArray){
            if (list.size > 0){
                val arrayFromList = Array<Long>(list.size) { i -> list[i] }
                for (value in InsertionSort().sort(arrayFromList)){
                    outputArray[outputArrayIndex] = value
                    outputArrayIndex++
                }
            }
        }
        intermed_res = sortArray
        res = outputArray.toLongArray()
    }

}

//[[-5], [], [0, -1], [1], [5]]

//[[-5], [], [-1, 0], [1], [5]]