public class Leetcode678 {

    static class Solution {

        public boolean checkValidString(String s) {

            // Minimum possible balance
            int min = 0;

            // Maximum possible balance
            int max = 0;

            for (char ch : s.toCharArray()) {

                if (ch == '(') {

                    min++;
                    max++;

                } else if (ch == ')') {

                    min--;
                    max--;

                } else {

                    // '*' can be '('
                    // or ')' or empty

                    min--;
                    max++;
                }

                // Even with the best choice,
                // we have too many ')'
                if (max < 0) {
                    return false;
                }

                // Minimum cannot stay negative.
                // We can use '*' as empty or '('.
                min = Math.max(min, 0);
            }

            // We need some possibility with balance 0
            return min == 0;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "(*))";

        boolean result =
                solution.checkValidString(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}