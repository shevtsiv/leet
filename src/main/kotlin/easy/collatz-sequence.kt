package easy

class CollatzSequenceSolution {

    /**
     * Time Complexity: O(?)
     * Space Complexity: O(1)
     */
    fun collatzSequence(nInput: Int): Int {
        var n = nInput
        var length = 0
        while (n != 1) {
            if (n and 1 == 0) {
                n /= 2
                length++
            } else {
                n = 3 * n + 1
                length++
            }
        }
        return length + 1
    }
}
