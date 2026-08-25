class Leetcode3718 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = { 8, 2, 3, 4, 6 };
        int k = 2;

        int result = solution.missingMultiple(nums, k);

        System.out.println("Smallest missing multiple = " + result);
    }
}

class Solution {

    public int missingMultiple(int[] nums, int k) {

        boolean[] present = new boolean[101];

        // Mark all numbers that are present
        for (int num : nums) {
            present[num] = true;
        }

        // Check k, 2*k, 3*k, ...
        for (int i = 1;; i++) {

            int multiple = k * i;

            // If it is greater than 100, it cannot exist in nums
            if (multiple >= 101 || !present[multiple]) {
                return multiple;
            }
        }
    }
}