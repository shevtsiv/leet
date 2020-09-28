package easy

class PascalsTriangleSolution {

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */
    fun generate(numRows: Int): List<List<Int>> {
        val triangle = ArrayList<ArrayList<Int>>(numRows)
        if (numRows == 0) {
            return triangle
        }
        var prevRow = arrayListOf(1)
        var currentRowSize = 2
        triangle.add(prevRow)
        for (x in 1 until numRows) {
            val currentRow = ArrayList<Int>()
            for (i in 0 until currentRowSize) {
                if (i - 1 < 0 || i >= prevRow.size) {
                    currentRow.add(1)
                    continue
                }
                val leftParent = prevRow[i - 1]
                val rightParent = prevRow[i]
                currentRow.add(leftParent + rightParent)
            }
            currentRowSize++
            triangle.add(currentRow)
            prevRow = currentRow
        }
        return triangle
    }
}
