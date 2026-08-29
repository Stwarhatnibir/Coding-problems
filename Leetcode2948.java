import java.util.*;

class Leetcode2948 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {1, 5, 3, 9, 8};
        int limit = 2;

        int[] result = solution.lexicographicallySmallestArray(nums, limit);

        System.out.println(Arrays.toString(result));
    }
}

class Solution {

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        // Copy and sort the array
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // Each group stores the values that can be swapped
        List<List<Integer>> groups = new ArrayList<>();

        // Map value -> group number
        Map<Integer, Integer> groupMap = new HashMap<>();

        int group = -1;

        for (int i = 0; i < n; i++) {

            // Start a new group if the difference
            // between consecutive sorted values > limit
            if (i == 0 || sorted[i] - sorted[i - 1] > limit) {
                group++;
                groups.add(new ArrayList<>());
            }

            groups.get(group).add(sorted[i]);

            groupMap.put(sorted[i], group);
        }

        // Pointer for each group
        int[] pointer = new int[group + 1];

        int[] result = new int[n];

        // Put each original value into its group's
        // smallest available value
        for (int i = 0; i < n; i++) {

            int value = nums[i];

            int groupId = groupMap.get(value);

            result[i] =
                    groups.get(groupId).get(pointer[groupId]);

            pointer[groupId]++;
        }

        return result;
    }
}