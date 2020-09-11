package easy

class HappyNumberSolution {

    /**
     * Time Complexity: O(k*log10(n)), where k - length of a cycle in case of unhappy number
     * Space Complexity: O(k), where k - length of a cycle in case of unhappy number
     */
    private val previousNumbers = HashSet<Int>()
    fun isHappyUsingHashSet(originalN: Int): Boolean {
        var n = originalN
        while (n != 1) {
            var nCopy = n
            var newSum = 0
            while (nCopy != 0) {
                newSum += (nCopy % 10) * (nCopy % 10)
                nCopy /= 10
            }
            if (!previousNumbers.add(newSum)) {
                return false
            }
            n = newSum
        }
        return true
    }
}
