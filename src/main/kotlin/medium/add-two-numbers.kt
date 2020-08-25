package medium

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class AddTwoNumbersSolution {

    /**
     * Time Complexity: O(max(n, m)), where n = l1.length, m = l2.length
     * Space Complexity: O(max(n, m)), where n = l1.length, m = l2.length
     */
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result = ListNode(0)
        val finalResultReference = result

        var first = l1
        var second = l2
        var carry = 0

        while (first != null && second != null) {
            val firstValue = first.`val`
            val secondValue = second.`val`
            var sum = firstValue + secondValue + carry
            if (sum >= 10) {
                carry = 1
                sum -= 10
            } else {
                carry = 0
            }
            result.`val` = sum
            first = first.next
            second = second.next
            if (first != null || second != null) {
                val nextNode = ListNode(0)
                result.next = nextNode
                result = nextNode
            }
        }

        while (first != null) {
            var sum = first.`val` + carry
            if (sum >= 10) {
                carry = 1
                sum -= 10
            } else {
                carry = 0
            }
            result.`val` = sum
            first = first.next
            if (first != null) {
                val nextNode = ListNode(0)
                result.next = nextNode
                result = nextNode
            }
        }

        while (second != null) {
            var sum = second.`val` + carry
            if (sum >= 10) {
                carry = 1
                sum -= 10
            } else {
                carry = 0
            }
            result.`val` = sum
            second = second.next
            if (second != null) {
                val nextNode = ListNode(0)
                result.next = nextNode
                result = nextNode
            }
        }

        if (carry == 1) {
            val nextNode = ListNode(1)
            result.next = nextNode
        }

        return finalResultReference
    }
}
