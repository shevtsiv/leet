package easy

class ValidAnagramSolution {

    /**
     * Time Complexity: O(3n) => O(n), where n - length of one of the input strings
     * Space Complexity: O(2n) => O(n), where n - length of one of the input strings
     */
    fun isAnagramBruteforce(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val first = HashMap<Char, Int>(s.length)
        for (char in s) {
            if (first.contains(char)) {
                first[char] = first[char]!! + 1
            } else {
                first[char] = 1
            }
        }
        val second = HashMap<Char, Int>(s.length)
        for (char in t) {
            if (second.contains(char)) {
                second[char] = second[char]!! + 1
            } else {
                second[char] = 1
            }
        }
        for (k in s) {
            if (first[k] != second[k]) {
                return false
            }
        }
        return true
    }

    /**
     * Time Complexity: O(2n) => O(n), where n - length of one of the input strings
     * Space Complexity: O(n) => O(n), where n - length of one of the input strings
     */
    fun isAnagramTwoPass(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val table = HashMap<Char, Int>(s.length)
        for (char in s) {
            if (table.contains(char)) {
                table[char] = table[char]!! + 1
            } else {
                table[char] = 1
            }
        }
        for (char in t) {
            if (table.contains(char)) {
                table[char] = table[char]!! - 1
                if (table[char]!! < 0) {
                    return false
                }
            } else {
                return false
            }
        }
        return true
    }

    /**
     * Time Complexity: O(2n) => O(n), where n - length of one of the input strings
     * Space Complexity: O(1)
     */
    fun isAnagramUsingArray(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val table = IntArray(26)
        for (char in s) {
            table[char - 'a'] += 1
        }
        for (char in t) {
            table[char - 'a'] -= 1
            if (table[char - 'a'] < 0) {
                return false
            }
        }
        return true
    }
}
