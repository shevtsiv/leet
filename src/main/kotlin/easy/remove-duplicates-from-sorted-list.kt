package easy

class RemoveDuplicatesFromSortedListSolution {

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
