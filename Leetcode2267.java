public class Leetcode2267 {

    static class Solution {

        public boolean hasValidPath(char[][] grid) {

            int m = grid.length;
            int n = grid[0].length;

            // A valid parentheses string must have even length.
            if ((m + n - 1) % 2 != 0) {
                return false;
            }

            // Start must be '(' and end must be ')'.
            if (grid[0][0] != '(' ||
                    grid[m - 1][n - 1] != ')') {
                return false;
            }

            boolean[][][] dp = new boolean[m][n][m + n];

            // Starting cell
            dp[0][0][1] = true;

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < n; j++) {

                    // Starting cell already initialized
                    if (i == 0 && j == 0) {
                        continue;
                    }

                    int value = grid[i][j] == '(' ? 1 : -1;

                    for (int balance = 0; balance < m + n; balance++) {

                        int previousBalance = balance - value;

                        if (previousBalance < 0) {
                            continue;
                        }

                        // Come from above
                        if (i > 0 &&
                                dp[i - 1][j][previousBalance]) {

                            dp[i][j][balance] = true;
                        }

                        // Come from left
                        if (j > 0 &&
                                dp[i][j - 1][previousBalance]) {

                            dp[i][j][balance] = true;
                        }
                    }
                }
            }

            return dp[m - 1][n - 1][0];
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        char[][] grid = {
                { '(', '(', '(' },
                { '(', '(', ')' },
                { '(', '(', ')' }
        };

        boolean result = solution.hasValidPath(grid);

        System.out.println("Output: " + result);
    }
}