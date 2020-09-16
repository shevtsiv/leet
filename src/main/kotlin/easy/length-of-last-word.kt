package easy

class LengthOfLastWordSolution {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun lengthOfLastWord(s: String): Int {
        var lastWordLength = 0
        for (i in s.length - 1 downTo 0) {
            if (s[i] == ' ') {
                if (lastWordLength != 0) {
                    return lastWordLength
                }
            } else {
                lastWordLength++
            }
        }
        return lastWordLength
    }
}
