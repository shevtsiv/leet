package easy

class UniqueNumberOfOccurrencesSolution {

    /**
     * Time Complexity: O(2n) => O(n)
     * Space Complexity: O(2n)
     */
    fun uniqueOccurrencesUsingMapAndSet(arr: IntArray): Boolean {
        val frequencyTable = HashMap<Int, Int>(arr.size)
        for (x in arr) {
            val counter = frequencyTable[x]
            if (counter == null) {
                frequencyTable[x] = 1
            } else {
                frequencyTable[x] = counter + 1
            }
        }
        val uniqueCounters = HashSet<Int>(frequencyTable.size)
        for (x in frequencyTable.values) {
            if (!uniqueCounters.add(x)) {
                return false
            }
        }
        return true
    }
}
