import java.util.*;

public class Leetcode835 {

    static class Solution {
        public int largestOverlap(int[][] img1, int[][] img2) {

            int n = img1.length;

            Map<String, Integer> count = new HashMap<>();
            int answer = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (img1[i][j] == 0) {
                        continue;
                    }

                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < n; y++) {

                            if (img2[x][y] == 0) {
                                continue;
                            }

                            int dx = i - x;
                            int dy = j - y;

                            String key = dx + "," + dy;

                            int current = count.getOrDefault(key, 0) + 1;
                            count.put(key, current);

                            answer = Math.max(answer, current);
                        }
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] img1 = {
            {1, 1, 0},
            {0, 1, 0},
            {0, 1, 0}
        };

        int[][] img2 = {
            {0, 0, 0},
            {0, 1, 1},
            {0, 0, 1}
        };

        int result = solution.largestOverlap(img1, img2);

        System.out.println("Output: " + result);
    }
}