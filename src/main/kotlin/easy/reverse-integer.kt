package easy

import kotlin.math.absoluteValue
import kotlin.math.pow

/**
 * Time Complexity: O(2log(x)) => O(log(x))
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
