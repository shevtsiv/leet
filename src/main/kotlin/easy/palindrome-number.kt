package easy

import kotlin.math.pow
import kotlin.math.log10

/**
 * Time Complexity: O(2log10(x)) => O(log10(x))
 * Space Complexity: O(1)
 */
fun isPalindrome(x: Int): Boolean {
    return when {
        x < 0 -> false
        x < 10 -> true
        else -> x == reversePositive(x)
    }
}

/**
 * Time Complexity: O(2log10(x)) => O(log10(x))
 * Space Complexity: O(1)
 */
fun reversePositive(x: Int): Int {
    var initial = x
    var digitsAmount = log10(x.toDouble()).toInt() + 1
    var reversed = 0
    while (initial > 0) {
        reversed += (initial % 10 * 10.0.pow(--digitsAmount)).toInt()
        if (reversed < 0) {
            return 0
        }
        initial /= 10
    }
    return reversed
}

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
fun isPalindromeUsingString(x: Int): Boolean {
    val stringRepresentation = x.toString()
    return stringRepresentation == stringRepresentation.reversed()
}
