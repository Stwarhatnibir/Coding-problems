public class Leetcode3550 {

    static class Solution {

        public int smallestIndex(int[] nums) {

            for (int i = 0; i < nums.length; i++) {

                int num = nums[i];
                int sum = 0;

                while (num > 0) {
                    sum += num % 10;
                    num /= 10;
                }

                if (sum == i) {
                    return i;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {1, 3, 2};

        int result = solution.smallestIndex(nums);

        System.out.println("Output: " + result);
    }
}