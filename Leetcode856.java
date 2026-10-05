import java.util.*;

public class Leetcode856 {

    static class Solution {

        public int scoreOfParentheses(String s) {

            Stack<Integer> stack = new Stack<>();

            // Score outside the current parentheses
            stack.push(0);

            for (char ch : s.toCharArray()) {

                if (ch == '(') {

                    // Start a new group
                    stack.push(0);

                } else {

                    // Score inside current ()
                    int inside = stack.pop();

                    // Score of this group
                    int score;

                    if (inside == 0) {
                        score = 1;
                    } else {
                        score = 2 * inside;
                    }

                    // Add to previous level
                    int previous = stack.pop();

                    stack.push(previous + score);
                }
            }

            return stack.peek();
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "(()(()))";

        int result = solution.scoreOfParentheses(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}