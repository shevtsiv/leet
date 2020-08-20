package easy

/**
 * Time Complexity: O(n - 1) => O(n)
 * Space Complexity: O(1)
 */
fun romanToInt(s: String): Int {
    var prev = convertToInt(s[0])
    var result = prev
    for (i in 1 until s.length) {
        val digit = convertToInt(s[i])
        if (prev >= digit) {
            result += digit
        } else {
            result -= prev
            result += digit - prev
        }
        prev = digit
    }
    return result
}

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
fun convertToInt(char: Char): Int {
    return when (char) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> {
            throw RuntimeException("Invalid Roman Number supplied: $char")
        }
    }
}
