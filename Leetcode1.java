import java.util.HashMap;
import java.util.Map;

class Leetcode1 {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = s.twoSum(nums, target);

        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }

            numMap.put(nums[i], i);
        }

        return new int[]{};
    }
}