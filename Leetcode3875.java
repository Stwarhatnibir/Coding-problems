import java.util.*;

public class Leetcode3875 {

    static class Solution {

        public boolean uniformArray(int[] nums1) {
            return true;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums1 = {2, 3};

        boolean result = solution.uniformArray(nums1);

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + result);
    }
}