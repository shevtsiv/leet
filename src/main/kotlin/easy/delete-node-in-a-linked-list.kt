package easy

class DeleteNodeInALinkedListSolution {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun deleteNode(inputNode: ListNode) {
        var node = inputNode
        while (node.next != null) {
            val next = node.next!!
            node.`val` = next.`val`
            if (next.next == null) {
                node.next = null
            } else {
                node = next
            }
        }
    }
}
