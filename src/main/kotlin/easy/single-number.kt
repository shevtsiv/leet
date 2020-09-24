package easy

class SingleNumberSolution {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    fun singleNumberUsingHashSet(nums: IntArray): Int {
        val set = HashSet<Int>(nums.size)
        for (x in nums) {
            if (!set.add(x)) {
                set.remove(x)
            }
        }
        return set.first()
    }
}
