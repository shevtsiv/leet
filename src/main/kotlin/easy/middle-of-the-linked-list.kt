package easy

class MiddleOfTheLinkedListSolution {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast != null) {
            fast = fast.next
            if (fast != null) {
                slow = slow!!.next
                fast = fast.next
            } else {
                return slow
            }
        }
        return slow
    }
}
