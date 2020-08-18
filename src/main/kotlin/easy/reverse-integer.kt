package easy

import kotlin.math.absoluteValue
import kotlin.math.pow

/**
 * Time Complexity: O(2log10(x)) => O(log(x))
 * Space Complexity: O(1)
 */
fun reverse(x: Int): Int {
    var initial = x.absoluteValue
    var initialCopy = initial
    var digitsAmount = 0
    while (initialCopy > 0) {
        initialCopy /= 10
        digitsAmount++
    }
    var reversed = 0
    while (initial > 0) {
        reversed += (initial % 10 * 10.0.pow(--digitsAmount)).toInt()
        if (reversed < 0) {
            return 0
        }
        initial /= 10
    }
    if (x < 0) {
        reversed = -reversed
    }
    return reversed
}

/**
 * Time Complexity: O(log10(x))
 * Space Complexity: O(1)
 */
fun reverseUsingString(x: Int): Int {
    var sign = 0
    val xStr = x.toString()
    val stringRepresentation =  if (xStr.startsWith("-")) {
        sign = -1
        xStr.substring(1)
    } else {
        xStr
    }
    return try {
        val reversed = stringRepresentation.reversed().toInt()
        if (sign == -1) {
            -reversed
        } else {
            reversed
        }
    } catch (e : NumberFormatException) {
        0
    }
}
