package easy

/**
 * Time Complexity: n * (n - 1) = n^2 - n => O(n^2)
 * Space Complexity: O(1)
 */
fun twoSumTwoPass(nums: IntArray, target: Int): IntArray {
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return IntArray(0)
}

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
fun twoSumOnePassWithMap(nums: IntArray, target: Int): IntArray {
    val previousElements = HashMap<Int, Int>(nums.size)
    for (i in nums.indices) {
        val currentNumber = nums[i]
        val difference = target - currentNumber
        if (previousElements.contains(difference)) {
            return intArrayOf(previousElements[difference]!!, i)
        }
        previousElements[currentNumber] = i
    }
    return IntArray(0)
}
