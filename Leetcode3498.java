public class Leetcode3498 {

    static class Solution {

        public int reverseDegree(String s) {

            int result = 0;

            for (int i = 0; i < s.length(); i++) {

                int value = 'z' - s.charAt(i) + 1;

                int position = i + 1;

                result += value * position;
            }

            return result;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "abc";

        int result = solution.reverseDegree(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}