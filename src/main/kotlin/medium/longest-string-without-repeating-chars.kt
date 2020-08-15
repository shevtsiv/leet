package medium

import kotlin.math.max

/**
 * Time Complexity: O(n^3)
 * Space Complexity: O(n)
 */
fun lengthOfLongestSubstring(s: String): Int {
    var maxLength = 0
    val buffer = StringBuilder(s.length)
    var substringStartIndex = 0
    var i = 0
    while (i < s.length) {
        val char = s[i]
        if (buffer.indexOf(char) != -1) {
            if (buffer.length > maxLength) {
                maxLength = buffer.length
            }
            i = ++substringStartIndex - 1
            buffer.clear()
        } else {
            buffer.append(char)
        }
        i++
    }
    return max(buffer.length, maxLength)
}
