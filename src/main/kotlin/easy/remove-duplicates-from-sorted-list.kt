package easy

class RemoveDuplicatesFromSortedListSolution {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun deleteDuplicatesUsingTwoPointers(headInput: ListNode?): ListNode? {
        var slow = headInput
        var fast = headInput
        while (fast != null) {
            if (slow!!.`val` != fast.`val`) {
                slow.next = fast
                slow = slow.next
            } else {
                fast = fast.next
            }
        }
        slow!!.next = null // cut off the rest of the list after the fast pointer reached the end
        return headInput
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun deleteDuplicates(headInput: ListNode?): ListNode? {
        var head = headInput
        while (head != null) {
            val nextNode = head.next
            if (nextNode != null && nextNode.`val` == head.`val`) {
                head.next = nextNode.next
            } else {
                head = nextNode
            }
        }
        return headInput
    }
}
