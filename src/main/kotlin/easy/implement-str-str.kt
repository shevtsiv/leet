package easy

class ImplementStrStrSolution {

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    fun strStr(haystack: String, needle: String): Int {
        if (haystack.isEmpty() && needle.isEmpty()) {
            return 0
        }
        for (i in haystack.indices) {
            var matches = true
            var j = 0
            var iCopy = i
            while (j < needle.length) {
                if (iCopy == haystack.length) {
                    return -1
                }
                if (haystack[iCopy++] != needle[j++]) {
                    matches = false
                    break
                }
            }
            if (matches) {
                return i
            }
        }
        return -1
    }
}
