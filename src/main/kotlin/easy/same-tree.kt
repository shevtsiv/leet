package easy

class SameTreeSolution {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(log(n)) when tree is balanced, O(n) otherwise
     */
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null || q == null) {
            return p == q
        }
        return p.`val` == q.`val` && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}
