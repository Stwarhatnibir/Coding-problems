public class Leetcode1621 {

    static class Solution {
        private static final int MOD = 1_000_000_007;

        public int numberOfSets(int n, int k) {

            int[][] f = new int[n + 1][k + 1];
            int[][] g = new int[n + 1][k + 1];

            // f[i][j] = ways using first i points
            // where we are NOT currently ending a segment at point i-1
            //
            // g[i][j] = ways where a segment is currently ending at point i-1

            f[1][0] = 1;

            for (int i = 2; i <= n; i++) {

                for (int j = 0; j <= k; j++) {

                    // Do not use point i-1 to extend/start a segment
                    f[i][j] = (f[i - 1][j] + g[i - 1][j]) % MOD;

                    // Continue an existing segment
                    g[i][j] = g[i - 1][j];

                    if (j > 0) {

                        // Start a new segment
                        g[i][j] += f[i - 1][j - 1];
                        g[i][j] %= MOD;

                        // Start a new segment while previous segment
                        // also ends at this point
                        g[i][j] += g[i - 1][j - 1];
                        g[i][j] %= MOD;
                    }
                }
            }

            return (f[n][k] + g[n][k]) % MOD;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int n = 4;
        int k = 2;

        int result = solution.numberOfSets(n, k);

        System.out.println("n = " + n);
        System.out.println("k = " + k);
        System.out.println("Output = " + result);
    }
}