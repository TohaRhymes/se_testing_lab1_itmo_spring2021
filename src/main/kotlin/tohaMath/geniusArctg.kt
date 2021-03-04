package tohaMath

import kotlin.math.abs
import kotlin.math.pow

fun genius_arctg(x: Double, eps: Double): Double {
    return if (abs(x) > 1) {
        println("Wrong Input, |X|>1")
        Double.NaN
    } else {
        var n = 0
        var curAnswer = 0.0
        var newAnswer = 0.0
        do {
            curAnswer = newAnswer
            newAnswer += (-1.0).pow(n) * x.pow(2 * n + 1) / (2 * n + 1)
            n+=1
        }while((abs(newAnswer - curAnswer) > eps))
        newAnswer
    }
}


