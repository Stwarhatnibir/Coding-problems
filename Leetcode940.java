public class Leetcode940 {

    static class Solution {

        public int distinctSubseqII(String s) {

            final int MOD = 1_000_000_007;

            // dp[i] = number of distinct subsequences
            // ending with character i
            long[] dp = new long[26];

            for (char c : s.toCharArray()) {

                int index = c - 'a';

                long total = 1;

                for (int i = 0; i < 26; i++) {
                    total += dp[i];
                }

                // All previous subsequences can be extended
                // by the current character.
                dp[index] = total % MOD;
            }

            long answer = 0;

            for (long x : dp) {
                answer += x;
            }

            return (int) (answer % MOD);
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "abc";

        int result = solution.distinctSubseqII(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}