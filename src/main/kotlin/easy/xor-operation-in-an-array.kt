package easy

class XorOperationInAnArraySolution {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    fun xorOperation(n: Int, start: Int): Int {
        val nums = IntArray(n)
        nums[0] = start
        for (i in 1 until n) {
            nums[i] = nums[i - 1] xor start + 2 * i
        }
        return nums[n - 1]
    }
}
