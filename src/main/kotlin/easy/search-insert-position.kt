package easy

class SearchInsertPositionSolution {

    /**
     * Time Complexity: O(log(n))
     * Space Complexity: O(1)
     */
    fun searchInsertUsingBinarySearch(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size
        while (low <= high) {
            val mid = (low + high) / 2
            when {
                nums[mid] < target -> {
                    low = mid + 1
                }
                nums[mid] > target -> {
                    high = mid - 1
                }
                else -> {
                    return mid
                }
            }
        }
        return low
    }

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
