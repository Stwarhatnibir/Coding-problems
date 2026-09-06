public class Leetcode8 {

    static class Solution {

        public int myAtoi(String s) {

            int i = 0;
            int n = s.length();

            // 1. Skip leading spaces
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }

            // 2. Check sign
            int sign = 1;

            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                if (s.charAt(i) == '-') {
                    sign = -1;
                }
                i++;
            }

            // 3. Convert digits
            int result = 0;

            while (i < n && Character.isDigit(s.charAt(i))) {

                int digit = s.charAt(i) - '0';

                // Check overflow
                if (result > Integer.MAX_VALUE / 10 ||
                        (result == Integer.MAX_VALUE / 10 &&
                                digit > 7)) {

                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                result = result * 10 + digit;
                i++;
            }

            return result * sign;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "   -42";

        int result = solution.myAtoi(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}