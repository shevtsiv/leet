package easy

class WaterBottlesSolution {

    /**
     * Time Complexity: O(log(n)), where n - numBottles
     * Space Complexity: O(1)
     */
    fun numWaterBottles(numBottlesInput: Int, numExchange: Int): Int {
        var numBottles = numBottlesInput
        var total = numBottles
        while (numBottles >= numExchange) {
            val carry = numBottles % numExchange
            numBottles /= numExchange
            total += numBottles
            numBottles += carry
        }
        return total
    }
}
