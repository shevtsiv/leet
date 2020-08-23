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

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(k^2), where k - length of the shortest string in the array
 */
fun longestCommonPrefixBruteforceUsingHorizontalScan(strs: Array<String>): String {
    if (strs.isEmpty() || strs[0].isEmpty()) {
        return ""
    }
    if (strs.size == 1) {
        return strs[0]
    }
    var prefix = getCommonLongestPrefix(strs[0], strs[1])
    for (i in 2 until strs.size) {
        if (prefix.isEmpty()) {
            return ""
        }
        val str = strs[i]
        prefix = getCommonLongestPrefix(prefix, str)
    }
    return prefix
}

/**
 * Time Complexity: O(min(n,m)), where n - length of the first string, m - length of the second string
 * Space Complexity: O(1), worst case: O(k), where k - common prefix length which is shorter than the shorter string
 */
fun getCommonLongestPrefix(first: String, second: String): String {
    val minimumLengthString = if (first.length > second.length) {
        second
    } else {
        first
    }
    for (i in minimumLengthString.indices) {
        if (first[i] != second[i]) {
            return minimumLengthString.substring(0, i)
        }
    }
    return minimumLengthString
}
