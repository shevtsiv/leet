package easy

class RemoveLinkedListElementsSolution {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun removeElements(headInput: ListNode?, `val`: Int): ListNode? {
        var head = headInput
        while (head != null) {
            var next = head.next
            while (next != null && next.`val` == `val`) {
                next = next.next
            }
            head.next = next
            head = head.next
        }
        return if (headInput?.`val` == `val`) {
            headInput.next
        } else {
            headInput
        }
    }
}
