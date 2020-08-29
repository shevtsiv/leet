package easy

import kotlin.math.pow

class ConvertBinaryNumberInALinkedListToInteger {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun getDecimalValueUsingShift(head: ListNode?): Int {
        var node = head
        var result = 0
        while (node != null) {
            result = (result shl 1) or node.`val`
            node = node.next
        }
        return result
    }

    /**
     * Time Complexity: O(2n) => O(n)
     * Space Complexity: O(1)
     */
    fun getDecimalValueByReversingList(head: ListNode?): Int {
        var prev: ListNode? = null
        var current = head
        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }
        var result = 0
        var power = 0
        while (prev != null) {
            result += prev.`val` * 2.0.pow(power++.toDouble()).toInt()
            prev = prev.next
        }
        return result
    }
}
