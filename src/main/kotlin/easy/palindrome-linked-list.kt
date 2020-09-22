package easy

class PalindromeLinkedListSolution {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun isPalindrome(head: ListNode?): Boolean {
        var start = head
        val middle = middleNode(start)
        var end = reverse(middle)
        while (end != null && start != null) {
            if (end.`val` != start.`val`) {
                return false
            }
            end = end.next
            start = start.next
        }
        return true
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private fun reverse(startNode: ListNode?): ListNode? {
        var head = startNode
        var lastNode: ListNode? = null
        while (head != null) {
            val next = head.next
            head.next = lastNode
            lastNode = head
            head = next
        }
        return lastNode
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private fun middleNode(head: ListNode?): ListNode? {
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
