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
    fun isSameTreeRecursive(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null || q == null) {
            return p == q
        }
        return p.`val` == q.`val` && isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right)
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(log(n)) when tree is balanced, O(n) otherwise
     */
    @ExperimentalStdlibApi
    fun isSameTreeIterative(p: TreeNode?, q: TreeNode?): Boolean {
        fun TreeNode?.isNotEqualTo(that: TreeNode?): Boolean {
            if (this == null || that == null) {
                return this != that
            }
            return this.`val` != that.`val`
        }
        if (p.isNotEqualTo(q)) {
            return false
        }
        val stackP = ArrayDeque<TreeNode?>()
        val stackQ = ArrayDeque<TreeNode?>()
        stackP.addFirst(p)
        stackQ.addFirst(q)
        while (!stackP.isEmpty()) {
            val p = stackP.removeFirst()
            val q = stackQ.removeFirst()
            if (p.isNotEqualTo(q)) {
                return false
            }
            if (p != null && q != null) {
                if (p.left.isNotEqualTo(q.left)) {
                    return false
                }
                if (p.left != null) {
                    stackP.addLast(p.left)
                    stackQ.addLast(q.left)
                }
                if (p.right.isNotEqualTo(q.right)) {
                    return false
                }
                if (p.right != null) {
                    stackP.addLast(p.right)
                    stackQ.addLast(q.right)
                }
            }
        }
        return true
    }
}
