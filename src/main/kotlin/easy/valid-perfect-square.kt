package easy

class ValidPerfectSquareSolution {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun isPerfectSquareBruteforce(num: Int): Boolean {
        for (x in 0..1_000_000) {
            val square = x * x
            if (square == num) {
                return true
            } else if (square < 0 || square > num) {
                return false
            }
        }
        return false
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun isPerfectSquareMath(numInput: Int): Boolean {
        var num = numInput
        var i = 1
        while (num > 0) {
            num -= i
            i += 2
        }
        return num == 0
    }
}
