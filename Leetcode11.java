import java.util.*;

public class Leetcode11 {

    static class Solution {

        public int maxArea(int[] height) {

            int left = 0;
            int right = height.length - 1;

            int maxArea = 0;

            while (left < right) {

                int width = right - left;
                int currentHeight = Math.min(height[left], height[right]);

                int area = width * currentHeight;

                maxArea = Math.max(maxArea, area);

                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            return maxArea;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = solution.maxArea(height);

        System.out.println("Input: " + Arrays.toString(height));
        System.out.println("Output: " + result);
    }
}