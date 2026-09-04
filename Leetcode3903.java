import java.util.*;

public class Leetcode3903 {

    static class Solution {

        public int firstStableIndex(int[] nums, int k) {

            int n = nums.length;

            // suffixMin[i] = minimum element from i to n-1
            int[] suffixMin = new int[n];

            suffixMin[n - 1] = nums[n - 1];

            for (int i = n - 2; i >= 0; i--) {
                suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
            }

            // prefix maximum
            int prefixMax = 0;

            for (int i = 0; i < n; i++) {

                prefixMax = Math.max(prefixMax, nums[i]);

                int instability = prefixMax - suffixMin[i];

                if (instability <= k) {
                    return i;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = { 5, 0, 1, 4 };
        int k = 3;

        int result = solution.firstStableIndex(nums, k);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println("Output: " + result);
    }
}