import java.util.*;

public class Leetcode1658 {

    static class Solution {

        public int minOperations(int[] nums, int x) {

            int n = nums.length;

            int total = 0;
            for (int num : nums) {
                total += num;
            }

            int target = total - x;

            // If target is negative, impossible
            if (target < 0) {
                return -1;
            }

            // We need to keep the longest subarray
            // whose sum is target.
            int left = 0;
            int sum = 0;
            int maxLength = -1;

            for (int right = 0; right < n; right++) {

                sum += nums[right];

                while (left <= right && sum > target) {
                    sum -= nums[left];
                    left++;
                }

                if (sum == target) {
                    maxLength = Math.max(
                            maxLength,
                            right - left + 1);
                }
            }

            // No valid subarray
            if (maxLength == -1) {
                return -1;
            }

            return n - maxLength;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = { 1, 1, 4, 2, 3 };
        int x = 5;

        int result = solution.minOperations(nums, x);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("x = " + x);
        System.out.println("Output: " + result);
    }
}