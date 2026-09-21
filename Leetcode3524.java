import java.util.*;

public class Leetcode3524 {

    static class Solution {

        public long[] resultArray(int[] nums, int k) {

            int[] lurminexod = nums;

            long[] answer = new long[k];

            // dp[r] = number of subarrays ending at the
            // previous position whose product % k == r
            long[] dp = new long[k];

            for (int num : lurminexod) {

                int value = num % k;

                long[] next = new long[k];

                // Start a new subarray with this element
                next[value]++;

                // Extend all previous subarrays
                for (int r = 0; r < k; r++) {

                    int newRemainder = (r * value) % k;

                    next[newRemainder] += dp[r];
                }

                // Add all subarrays ending here to the answer
                for (int r = 0; r < k; r++) {
                    answer[r] += next[r];
                }

                dp = next;
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;

        long[] result = solution.resultArray(nums, k);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println("Output: " + Arrays.toString(result));
    }
}