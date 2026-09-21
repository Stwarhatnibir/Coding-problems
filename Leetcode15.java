import java.util.*;

public class Leetcode15 {

    static class Solution {

        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> answer = new ArrayList<>();

            Arrays.sort(nums);

            int n = nums.length;

            for (int i = 0; i < n - 2; i++) {

                // Skip duplicate first elements
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                // Since array is sorted, sum cannot become 0
                if (nums[i] > 0) {
                    break;
                }

                int left = i + 1;
                int right = n - 1;

                while (left < right) {

                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum < 0) {
                        left++;
                    } 
                    else if (sum > 0) {
                        right--;
                    } 
                    else {

                        answer.add(Arrays.asList(
                            nums[i],
                            nums[left],
                            nums[right]
                        ));

                        left++;
                        right--;

                        // Skip duplicate left values
                        while (left < right &&
                               nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // Skip duplicate right values
                        while (left < right &&
                               nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = solution.threeSum(nums);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + result);
    }
}