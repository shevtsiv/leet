package easy

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(k^2), where k - length of the first string
 */
fun longestCommonPrefixBruteforce(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }
    var prefix = strs[0]
    var i = 1
    while (i < strs.size) {
        val str = strs[i]
        while (!str.startsWith(prefix)) {
            prefix = prefix.substring(0, prefix.length - 1)
        }
        i++
    }
    return prefix
}

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(1), worst case: O(k), where k = common prefix length
 */
fun longestCommonPrefixBruteforceUsingIndex(strs: Array<String>): String {
    if (strs.isEmpty() || strs[0].isEmpty()) {
        return ""
    }
    var i = 1
    var j = 0
    var symbol = strs[0][0]
    while (i < strs.size) {
        val str = strs[i]
        if (j >= str.length) {
            return str
        }
        val anotherSymbol = str[j]
        if (symbol != anotherSymbol) {
            return str.substring(0, j)
        }
        i++
        if (i == strs.size) {
            j++
            i = 0
            if (j >= strs[i].length) {
                return strs[i]
            }
            symbol = strs[i][j]
        }
    }
    return strs[0]
}
