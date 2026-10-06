public class Leetcode921 {

    static class Solution {

        public int minAddToMakeValid(String s) {

            int open = 0;
            int additions = 0;

            for (char ch : s.toCharArray()) {

                if (ch == '(') {
                    open++;
                } else {
                    if (open > 0) {
                        open--;
                    } else {
                        // No '(' available to match ')'
                        additions++;
                    }
                }
            }

            // Any remaining '(' need matching ')'
            return additions + open;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "()))((";

        int result = solution.minAddToMakeValid(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}