package easy

class MaximumDepthOfBinaryTreeSolution {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = maxDepth(root.left)
        val right = maxDepth(root.right)
        return 1 + if (left > right) {
            left
        } else {
            right
        }
    }
}
