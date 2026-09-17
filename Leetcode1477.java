import java.util.*;

public class Leetcode1477 {

    static class Solution {

        public int minSumOfLengths(int[] arr, int target) {

            int n = arr.length;
            int INF = Integer.MAX_VALUE / 2;

            // best[i] = minimum length of a valid subarray
            // completely inside the first i elements
            int[] best = new int[n + 1];

            Arrays.fill(best, INF);

            Map<Integer, Integer> prefixMap = new HashMap<>();

            // prefix sum 0 exists before the array starts
            prefixMap.put(0, 0);

            int prefixSum = 0;
            int answer = INF;

            for (int i = 1; i <= n; i++) {

                prefixSum += arr[i - 1];

                // By default, carry the previous best answer
                best[i] = best[i - 1];

                int needed = prefixSum - target;

                if (prefixMap.containsKey(needed)) {

                    int start = prefixMap.get(needed);

                    int length = i - start;

                    // Previous subarray must end before 'start'
                    if (best[start] != INF) {
                        answer = Math.min(
                            answer,
                            best[start] + length
                        );
                    }

                    // This is the best single subarray
                    // ending at or before i
                    best[i] = Math.min(best[i], length);
                }

                prefixMap.put(prefixSum, i);
            }

            return answer == INF ? -1 : answer;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] arr = {3, 2, 2, 4, 3};
        int target = 3;

        int result = solution.minSumOfLengths(arr, target);

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);
        System.out.println("Output: " + result);
    }
}