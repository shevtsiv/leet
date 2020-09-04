package easy

class SearchInsertPositionSolution {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun searchInsertUsingLinearScan(nums: IntArray, target: Int): Int {
        for (i in nums.indices) {
            if (nums[i] >= target) {
                return i
            }
        }
        return nums.size
    }
}
