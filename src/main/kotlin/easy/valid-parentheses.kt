package easy

import java.util.ArrayDeque

class ValidParenthesesSolution {

    /**
     * Time Complexity: O(n), where n - length of the input string
     * Space Complexity: O(n), where n - length of the input string
     */
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>(s.length)
        for (char in s) {
            when (char) {
                '(', '[', '{' -> stack.push(char)
                ')' -> if (stack.poll() != '(') {
                    return false
                }
                ']' -> if (stack.poll() != '[') {
                    return false
                }
                '}' -> if (stack.poll() != '{') {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}
