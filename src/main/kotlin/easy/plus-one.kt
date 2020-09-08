package easy

class PlusOneSolution {

    /**
     * Time Complexity: O(2n) => O(n)
     * Space Complexity: O(n + 1) => O(n)
     */
    fun plusOne(digits: IntArray): IntArray {
        var currentDigitIndex = digits.size - 1
        var carry = 1
        do {
            digits[currentDigitIndex] += carry
            carry = 0
            if (digits[currentDigitIndex] >= 10) {
                digits[currentDigitIndex] -= 10
                carry = if (digits[currentDigitIndex] == 0) {
                    1
                } else {
                    digits[currentDigitIndex]
                }
                currentDigitIndex--
            } else {
                break
            }
        } while (currentDigitIndex != -1 && carry != 0)
        if (carry != 0) {
            val extendedDigits = IntArray(digits.size + 1)
            extendedDigits[0] = carry
            var i = 1
            for (j in digits) {
                extendedDigits[i++] = j
            }
            return extendedDigits
        }
        return digits
    }
}
