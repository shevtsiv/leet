package easy

class ImplementStrStrSolution {

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    fun strStrUsingTwoPointers(haystack: String, needle: String): Int {
        if (needle.isEmpty()) {
            return 0
        }
        var j = 0
        var i = 0
        while (i < haystack.length) {
            if (haystack[i] == needle[j]) {
                j++
                if (j == needle.length) {
                    return i + 1 - j
                }
            } else {
                if (j != 0) {
                    i -= j
                    j = 0
                }
            }
            i++
        }
        return -1
    }

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
