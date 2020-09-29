package easy

class PathSumSolution {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(log n)
     */
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if (root == null) {
            return false
        }
        val left = root.left
        val right = root.right
        val currentValue = root.`val`
        if (left == null && right == null && sum - currentValue == 0) {
            return true
        }
        return hasPathSum(left, sum - currentValue) || hasPathSum(right, sum - currentValue)
    }
}
