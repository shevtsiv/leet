package medium

import kotlin.math.max

class LongestStringWithoutRepeatingCharsSolution {

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

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    fun lengthOfLongestSubstringUsingHashSetAsBuffer(s: String): Int {
        var maxLength = 0
        val buffer = HashSet<Char>(s.length)
        var substringStartIndex = 0
        var i = 0
        while (i < s.length) {
            val char = s[i]
            if (buffer.contains(char)) {
                if (buffer.size > maxLength) {
                    maxLength = buffer.size
                }
                i = ++substringStartIndex - 1
                buffer.clear()
            } else {
                buffer.add(char)
            }
            i++
        }
        return max(buffer.size, maxLength)
    }

    /**
     * Time Complexity: O(2n) => O(n)
     * Space Complexity: O(n)
     */
    fun lengthOfLongestSubstringUsingSlidingWindow(s: String): Int {
        var maxLength = 0
        val window = HashSet<Char>(s.length)
        var windowStartIndex = 0
        var windowEndIndex = 0
        while (windowStartIndex < s.length && windowEndIndex < s.length) {
            val char = s[windowEndIndex]
            if (window.contains(char)) {
                window.remove(s[windowStartIndex++])
            } else {
                window.add(char)
                windowEndIndex++
                maxLength = max(maxLength, windowEndIndex - windowStartIndex)
            }
        }
        return maxLength
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    fun lengthOfLongestSubstringUsingSlidingWindowOnHashMap(s: String): Int {
        var maxLength = 0
        val window = HashMap<Char, Int>(s.length)
        var windowStartIndex = 0
        var windowEndIndex = 0
        while (windowStartIndex < s.length && windowEndIndex < s.length) {
            val char = s[windowEndIndex]
            if (window.contains(char)) {
                windowStartIndex = max(windowStartIndex, window.remove(char)!!)
            } else {
                maxLength = max(maxLength, windowEndIndex - windowStartIndex + 1)
                window[char] = ++windowEndIndex
            }
        }
        return maxLength
    }
}
