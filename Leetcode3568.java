import java.util.*;

public class Leetcode3568 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String[] classroom = {
            "S.",
            ".L"
        };

        int energy = 3;

        int result =
                solution.minMoves(classroom, energy);

        System.out.println("Minimum moves = " + result);
    }
}


class Solution {

    public int minMoves(
            String[] classroom,
            int energy) {

        int n = classroom.length;
        int m = classroom[0].length();

        int startR = -1;
        int startC = -1;

        List<int[]> litter = new ArrayList<>();

        // Find S and L
        for (int r = 0; r < n; r++) {

            for (int c = 0; c < m; c++) {

                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    startR = r;
                    startC = c;
                }

                if (ch == 'L') {
                    litter.add(new int[]{r, c});
                }
            }
        }

        int k = litter.size();

        if (k == 0) {
            return 0;
        }

        // Give every litter a bit number
        int[][] litterId =
                new int[n][m];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < k; i++) {

            int r = litter.get(i)[0];
            int c = litter.get(i)[1];

            litterId[r][c] = i;
        }

        int fullMask = (1 << k) - 1;

        /*
         * visited[row][column][energy][mask]
         */
        boolean[][][][] visited =
                new boolean[
                        n
                ][
                        m
                ][
                        energy + 1
                ][
                        1 << k
                ];

        Queue<int[]> queue =
                new ArrayDeque<>();

        // r, c, energy, mask, moves
        queue.offer(new int[]{
                startR,
                startC,
                energy,
                0,
                0
        });

        visited[startR][startC][energy][0] = true;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!queue.isEmpty()) {

            int[] state = queue.poll();

            int r = state[0];
            int c = state[1];
            int currentEnergy = state[2];
            int mask = state[3];
            int moves = state[4];

            // Everything cleaned
            if (mask == fullMask) {
                return moves;
            }

            // No energy
            if (currentEnergy == 0) {
                continue;
            }

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                // Check boundaries
                if (nr < 0 || nr >= n ||
                    nc < 0 || nc >= m) {
                    continue;
                }

                // Wall
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int newEnergy =
                        currentEnergy - 1;

                int newMask = mask;

                // Collect litter
                if (litterId[nr][nc] != -1) {

                    newMask |=
                            1 << litterId[nr][nc];
                }

                // Recharge
                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }

                if (!visited[nr][nc][newEnergy][newMask]) {

                    visited[nr][nc][newEnergy][newMask] = true;

                    queue.offer(new int[]{
                            nr,
                            nc,
                            newEnergy,
                            newMask,
                            moves + 1
                    });
                }
            }
        }

        return -1;
    }
}