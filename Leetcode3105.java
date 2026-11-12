public class Leetcode3105 {

    static class Solution {

        public int longestMonotonicSubarray(int[] nums) {

            int inc = 1;
            int dec = 1;
            int answer = 1;

            for (int i = 1; i < nums.length; i++) {

                if (nums[i] > nums[i - 1]) {
                    inc++;
                    dec = 1;
                } else if (nums[i] < nums[i - 1]) {
                    dec++;
                    inc = 1;
                } else {
                    inc = 1;
                    dec = 1;
                }

                answer = Math.max(answer, Math.max(inc, dec));
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = { 1, 4, 3, 3, 2 };

        int result = solution.longestMonotonicSubarray(nums);

        System.out.println("Output: " + result);
    }
}