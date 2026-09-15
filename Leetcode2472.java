public class Leetcode2472 {

    static class Solution {

        public int maxPalindromes(String s, int k) {
            int n = s.length();

            // pal[i][j] = true if s[i...j] is a palindrome
            boolean[][] pal = new boolean[n][n];

            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {

                    if (s.charAt(i) == s.charAt(j) &&
                        (j - i <= 2 || pal[i + 1][j - 1])) {

                        pal[i][j] = true;
                    }
                }
            }

            // dp[i] = maximum number using first i characters
            int[] dp = new int[n + 1];

            for (int end = 1; end <= n; end++) {

                // Don't use a palindrome ending here
                dp[end] = dp[end - 1];

                for (int start = 0; start <= end - k; start++) {

                    if (pal[start][end - 1]) {
                        dp[end] = Math.max(
                            dp[end],
                            dp[start] + 1
                        );
                    }
                }
            }

            return dp[n];
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "abaccdbbd";
        int k = 3;

        int result = solution.maxPalindromes(s, k);

        System.out.println("Input: " + s);
        System.out.println("k = " + k);
        System.out.println("Output: " + result);
    }
}