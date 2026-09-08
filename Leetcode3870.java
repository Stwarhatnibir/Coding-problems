public class Leetcode3870 {

    static class Solution {

        public int countCommas(int n) {
            return Math.max(0, n - 999);
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int n = 1002;

        int result = solution.countCommas(n);

        System.out.println("Input: " + n);
        System.out.println("Output: " + result);
    }
}