package easy

class RemoveElementSolution {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun removeElementUsingTwoPointers(nums: IntArray, `val`: Int): Int {
        var leftPointer = 0
        var rightPointer = 0
        while (rightPointer < nums.size) {
            if (nums[rightPointer] == `val`) {
                rightPointer++
            } else {
                nums[leftPointer++] = nums[rightPointer++]
            }
        }
        return leftPointer
    }

    /**
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    fun removeElementByRemovingAndShiftingElements(nums: IntArray, `val`: Int): Int {
        var size = nums.size
        for (i in 0 until size) {
            while (nums[i] == `val` && i < size) {
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
