public class Leetcode10 {

    static class Solution {

        public boolean isMatch(String s, String p) {

            int m = s.length();
            int n = p.length();

            boolean[][] dp = new boolean[m + 1][n + 1];

            dp[0][0] = true;

            // Empty string vs patterns like a*, a*b*, a*b*c*
            for (int j = 2; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[0][j] = dp[0][j - 2];
                }
            }

            for (int i = 1; i <= m; i++) {

                for (int j = 1; j <= n; j++) {

                    char sChar = s.charAt(i - 1);
                    char pChar = p.charAt(j - 1);

                    // Normal character or '.'
                    if (pChar == '.' || pChar == sChar) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }

                    // '*'
                    else if (pChar == '*') {

                        // Use '*' as zero occurrences
                        dp[i][j] = dp[i][j - 2];

                        char previous = p.charAt(j - 2);

                        // Use '*' for one or more occurrences
                        if (previous == '.' || previous == sChar) {
                            dp[i][j] = dp[i][j] || dp[i - 1][j];
                        }
                    }
                }
            }

            return dp[m][n];
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "aab";
        String p = "c*a*b";

        boolean result = solution.isMatch(s, p);

        System.out.println("String: " + s);
        System.out.println("Pattern: " + p);
        System.out.println("Output: " + result);
    }
}