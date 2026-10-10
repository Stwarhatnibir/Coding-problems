import java.util.*;

public class Leetcode2333 {

    static class Solution {
        public long minSumSquareDiff(
                int[] nums1, int[] nums2, int k1, int k2) {

            int n = nums1.length;
            int maxDiff = 0;
            long totalDiff = 0;

            int[] diff = new int[n];

            for (int i = 0; i < n; i++) {
                diff[i] = Math.abs(nums1[i] - nums2[i]);
                maxDiff = Math.max(maxDiff, diff[i]);
                totalDiff += diff[i];
            }

            long k = (long) k1 + k2;

            // We can make every difference zero.
            if (k >= totalDiff) {
                return 0;
            }

            // Count how many differences have each value.
            long[] count = new long[maxDiff + 1];

            for (int d : diff) {
                count[d]++;
            }

            // Reduce the largest differences first.
            for (int d = maxDiff; d > 0 && k > 0; d--) {
                long moves = Math.min(k, count[d]);

                count[d] -= moves;
                count[d - 1] += moves;
                k -= moves;
            }

            long answer = 0;

            for (int d = 1; d < count.length; d++) {
                answer += count[d] * d * d;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {2, 10, 20, 19};
        int k1 = 0;
        int k2 = 0;

        System.out.println(
            solution.minSumSquareDiff(nums1, nums2, k1, k2)
        );
    }
}