package easy

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * Time Complexity: O(n + m), where n - length of the first list, m - length of the second list
 * Space Complexity: O(n + m), where n - length of the first list, m - length of the second list
 */
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var result = ListNode(0)
    val finalResultReference = result
    var first = l1
    var second = l2
    while (first != null && second != null) {
        val v1 = first.`val`
        val v2 = second.`val`
        if (v1 < v2) {
            val next = ListNode(v1)
            result.next = next
            result = next
            first = first.next
        } else {
            val next = ListNode(v2)
            result.next = next
            result = next
            second = second.next
        }
    }
    while (first != null) {
        val next = ListNode(first.`val`)
        result.next = next
        result = next
        first = first.next
    }
    while (second != null) {
        val next = ListNode(second.`val`)
        result.next = next
        result = next
        second = second.next
    }
    return finalResultReference.next
}
