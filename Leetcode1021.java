public class Leetcode1021 {

    static class Solution {

        public String removeOuterParentheses(String s) {

            StringBuilder result = new StringBuilder();

            int depth = 0;

            for (char ch : s.toCharArray()) {

                if (ch == '(') {

                    // If depth > 0, this is not
                    // the outermost '('
                    if (depth > 0) {
                        result.append(ch);
                    }

                    depth++;

                } else {

                    depth--;

                    // If depth > 0, this is not
                    // the outermost ')'
                    if (depth > 0) {
                        result.append(ch);
                    }
                }
            }

            return result.toString();
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "(()())(())";

        String result =
                solution.removeOuterParentheses(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}