package easy

class MergeSortedArraySolution {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun mergeUsingThreePointers(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i = m - 1
        var j = n - 1
        var endPointer = m + n - 1
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[endPointer--] = nums1[i--]
            } else {
                nums1[endPointer--] = nums2[j--]
            }
        }
        while (j >= 0) {
            nums1[endPointer--] = nums2[j--]
        }
    }

    /**
     * Time Complexity: O((n^2)log(n))
     * Space Complexity: O(1)
     */
    fun mergeUsingBinarySearch(nums1: IntArray, mInitial: Int, nums2: IntArray, _n: Int) {
        var m = mInitial - 1
        for (x in nums2) {
            insertIntoAt(x, nums1, findInsertPosition(nums1, m++, x))
        }
    }

    /**
     * Time Complexity: O(log(n))
     * Space Complexity: O(1)
     */
    private fun findInsertPosition(array: IntArray, size: Int, element: Int): Int {
        var lo = 0
        var hi = size
        while (lo <= hi) {
            val mid = (lo + hi) / 2
            when {
                array[mid] == element -> {
                    return mid
                }
                array[mid] < element -> {
                    lo = mid + 1
                }
                else -> {
                    hi = mid - 1
                }
            }
        }
        return lo
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private fun insertIntoAt(element: Int, array: IntArray, position: Int) {
        for (i in array.size - 1 downTo position + 1) {
            array[i] = array[i - 1]
        }
        array[position] = element
    }
}
