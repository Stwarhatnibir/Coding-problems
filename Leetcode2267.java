import java.util.*;

public class Leetcode2267 {

    static class Solution {

        public boolean hasValidPath(char[][] grid) {

            int m = grid.length;
            int n = grid[0].length;

            int length = m + n - 1;

            // Valid parentheses string must have even length.
            if (length % 2 != 0) {
                return false;
            }

            // Must start with '(' and end with ')'.
            if (grid[0][0] != '(' ||
                grid[m - 1][n - 1] != ')') {
                return false;
            }

            boolean[][][] dp =
                    new boolean[m][n][length + 1];

            // First cell is '('
            dp[0][0][1] = true;

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < n; j++) {

                    if (i == 0 && j == 0) {
                        continue;
                    }

                    int change =
                            grid[i][j] == '(' ? 1 : -1;

                    /*
                     * previousBalance is the balance
                     * BEFORE entering this cell.
                     *
                     * It can never be negative.
                     */
                    for (int previousBalance = 0;
                         previousBalance < length;
                         previousBalance++) {

                        boolean canReach = false;

                        // From above
                        if (i > 0 &&
                            dp[i - 1][j][previousBalance]) {

                            canReach = true;
                        }

                        // From left
                        if (j > 0 &&
                            dp[i][j - 1][previousBalance]) {

                            canReach = true;
                        }

                        if (!canReach) {
                            continue;
                        }

                        int newBalance =
                                previousBalance + change;

                        // Balance can never become negative.
                        if (newBalance < 0) {
                            continue;
                        }

                        // Safety check.
                        if (newBalance > length) {
                            continue;
                        }

                        dp[i][j][newBalance] = true;
                    }
                }
            }

            return dp[m - 1][n - 1][0];
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        char[][] grid = {
            {'(', '(', '('},
            {')', '(', ')'},
            {'(', '(', ')'},
            {'(', '(', ')'}
        };

        boolean result = solution.hasValidPath(grid);

        System.out.println("Output: " + result);
    }
}