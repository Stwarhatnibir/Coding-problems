import java.util.*;

public class Leetcode115 {

    static class Solution {

        public int numDistinct(String s, String t) {

            int m = s.length();
            int n = t.length();

            // dp[j] = number of ways to form t[0...j-1]
            // using characters processed from s
            long[] dp = new long[n + 1];

            dp[0] = 1;

            for (int i = 1; i <= m; i++) {

                // Traverse backwards so that dp[j - 1]
                // still represents the previous row.
                for (int j = n; j >= 1; j--) {

                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[j] += dp[j - 1];
                    }
                }
            }

            return (int) dp[n];
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "rabbbit";
        String t = "rabbit";

        int result = solution.numDistinct(s, t);

        System.out.println("s = " + s);
        System.out.println("t = " + t);
        System.out.println("Output = " + result);
    }
}