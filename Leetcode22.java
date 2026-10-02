import java.util.*;

public class Leetcode22 {

    static class Solution {

        public List<String> generateParenthesis(int n) {

            List<String> answer = new ArrayList<>();

            backtrack(
                    answer,
                    new StringBuilder(),
                    0,
                    0,
                    n);

            return answer;
        }

        private void backtrack(
                List<String> answer,
                StringBuilder current,
                int open,
                int close,
                int n) {

            // We used all brackets
            if (current.length() == 2 * n) {
                answer.add(current.toString());
                return;
            }

            // We can add '('
            if (open < n) {

                current.append('(');

                backtrack(
                        answer,
                        current,
                        open + 1,
                        close,
                        n);

                // Undo
                current.deleteCharAt(current.length() - 1);
            }

            // We can add ')' only if it is valid
            if (close < open) {

                current.append(')');

                backtrack(
                        answer,
                        current,
                        open,
                        close + 1,
                        n);

                // Undo
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int n = 3;

        List<String> result = solution.generateParenthesis(n);

        System.out.println("n = " + n);
        System.out.println("Output = " + result);
    }
}