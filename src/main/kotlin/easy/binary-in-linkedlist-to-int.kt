package easy

import kotlin.math.pow

class ConvertBinaryNumberInALinkedListToInteger {
    /**
     * Time Complexity: O(2n) => O(n)
     * Space Complexity: O(1)
     */
    fun getDecimalValue(head: ListNode?): Int {
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
