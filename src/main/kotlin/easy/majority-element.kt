package easy

class MajorityElementSolution {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    fun majorityElement(nums: IntArray): Int {
        val table = HashMap<Int, Int>(nums.size)
        for (x in nums) {
            val newValue = (table[x] ?: 0) + 1
            if (newValue > nums.size / 2) {
                return x
            } else {
                table[x] = newValue
            }
        }
        return -1
    }
}
