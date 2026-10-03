import java.util.*;

public class Leetcode32 {

    static class Solution {

        public int longestValidParentheses(String s) {

            Stack<Integer> stack = new Stack<>();

            // Base index before the current valid substring
            stack.push(-1);

            int maxLength = 0;

            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == '(') {

                    // Store index of '('
                    stack.push(i);

                } else {

                    // Match with previous '('
                    stack.pop();

                    if (stack.isEmpty()) {

                        // This ')' cannot be matched.
                        // It becomes the new starting boundary.
                        stack.push(i);

                    } else {

                        // Current valid substring length
                        int length = i - stack.peek();

                        maxLength =
                                Math.max(maxLength, length);
                    }
                }
            }

            return maxLength;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = ")()())";

        int result =
                solution.longestValidParentheses(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}