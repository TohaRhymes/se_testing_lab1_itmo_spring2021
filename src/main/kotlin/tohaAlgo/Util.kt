package tohaAlgo

/**
 * Returns maximum value of an array (a linear complexity operation).
 */
fun maximum(arr: Array<Long>) : Int{
    var max : Int = 0;
    for (value in arr){
        if (value > max){
            max = value.toInt();
        }
    }
    return max;
}