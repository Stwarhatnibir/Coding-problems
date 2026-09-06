public class Leetcode9 {

    static class Solution {

        public boolean isPalindrome(int x) {

            if (x < 0) {
                return false;
            }

            int original = x;
            int reversed = 0;

            while (x != 0) {
                int digit = x % 10;
                reversed = reversed * 10 + digit;
                x /= 10;
            }

            return original == reversed;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int x = 121;

        boolean result = solution.isPalindrome(x);

        System.out.println("Input: " + x);
        System.out.println("Output: " + result);
    }
}