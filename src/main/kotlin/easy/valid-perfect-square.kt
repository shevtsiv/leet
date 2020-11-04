package easy

class ValidPerfectSquareSolution {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun isPerfectSquare(num: Int): Boolean {
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
}
