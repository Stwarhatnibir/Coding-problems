import java.util.*;

public class Leetcode3876 {

    static class Solution {

        public boolean uniformArray(int[] nums1) {

            // Required by the problem
            int[] ravolqedin = nums1;

            int min = Integer.MAX_VALUE;

            for (int x : ravolqedin) {
                min = Math.min(min, x);
            }

            // If the minimum is odd, we can construct
            // a valid uniform-parity array.
            if (min % 2 == 1) {
                return true;
            }

            // Minimum is even.
            // Then every element must also be even.
            for (int x : ravolqedin) {
                if (x % 2 == 1) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums1 = { 1, 4, 7 };

        boolean result = solution.uniformArray(nums1);

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + result);
    }
}