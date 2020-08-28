package easy

class RemoveDuplicatesFromSortedArraySolution {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun removeDuplicatesUsingTwoPointers(nums: IntArray): Int {
        var leftPointer = 0
        var rightPointer = 0
        while (rightPointer < nums.size) {
            if (nums[leftPointer] != nums[rightPointer]) {
                nums[++leftPointer] = nums[rightPointer]
            }
            rightPointer++
        }
        return leftPointer + 1
    }

    /**
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    fun removeDuplicatesByRemovingAndShiftingElements(nums: IntArray): Int {
        var size = nums.size
        for (i in 0 until size - 1) {
            while (nums[i] == nums[i + 1] && i < size - 1) {
                removeElementAt(nums, i, size--)
            }
        }
        return size
    }

    private fun removeElementAt(nums: IntArray, index: Int, size: Int) {
        for (i in index until size - 1) {
            nums[i] = nums[i + 1]
        }
    }
}
