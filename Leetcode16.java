import java.util.*;

public class Leetcode16 {

    static class Solution {

        public int threeSumClosest(int[] nums, int target) {

            Arrays.sort(nums);

            int n = nums.length;

            int closest = nums[0] + nums[1] + nums[2];

            for (int i = 0; i < n - 2; i++) {

                int left = i + 1;
                int right = n - 1;

                while (left < right) {

                    int sum = nums[i] + nums[left] + nums[right];

                    // Update closest answer
                    if (Math.abs(sum - target) < Math.abs(closest - target)) {

                        closest = sum;
                    }

                    // Exact answer
                    if (sum == target) {
                        return sum;
                    }

                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

            return closest;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = { -1, 2, 1, -4 };
        int target = 1;

        int result = solution.threeSumClosest(nums, target);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Output: " + result);
    }
}