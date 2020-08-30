package easy

class UniqueIntegersInSortedList {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun countUniqueIntegersInSortedList(nums: IntArray): Int {
        var prevNumber = nums[0]
        var result = 0
        for (i in 1 until nums.size) {
            if (prevNumber != nums[i]) {
                result++
            }
            prevNumber = nums[i]
        }
        return result + 1
    }
}
