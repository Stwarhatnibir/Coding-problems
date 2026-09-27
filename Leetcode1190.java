import java.util.*;

public class Leetcode1190 {

    static class Solution {

        public String reverseParentheses(String s) {

            Stack<StringBuilder> stack = new Stack<>();

            StringBuilder current = new StringBuilder();

            for (char ch : s.toCharArray()) {

                if (ch == '(') {

                    // Save current string
                    stack.push(current);

                    // Start a new string
                    current = new StringBuilder();

                } else if (ch == ')') {

                    // Reverse everything inside parentheses
                    current.reverse();

                    // Get the string before '('
                    StringBuilder previous = stack.pop();

                    // Append reversed content
                    previous.append(current);

                    current = previous;

                } else {

                    current.append(ch);
                }
            }

            return current.toString();
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "(u(love)i)";

        String result = solution.reverseParentheses(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}