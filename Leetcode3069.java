import java.util.Arrays;

class Leetcode3069 {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums = { 2, 1, 3 };

        int[] result = s.resultArray(nums);

        System.out.println(Arrays.toString(result));
    }
}

class Solution {

    public int[] resultArray(int[] nums) {

        int n = nums.length;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        int size1 = 0;
        int size2 = 0;

        // First element goes to arr1
        arr1[size1++] = nums[0];

        // Second element goes to arr2
        arr2[size2++] = nums[1];

        // Process remaining elements
        for (int i = 2; i < n; i++) {

            if (arr1[size1 - 1] > arr2[size2 - 1]) {
                arr1[size1++] = nums[i];
            } else {
                arr2[size2++] = nums[i];
            }
        }

        // Combine arr1 and arr2
        int[] result = new int[n];

        int index = 0;

        for (int i = 0; i < size1; i++) {
            result[index++] = arr1[i];
        }

        for (int i = 0; i < size2; i++) {
            result[index++] = arr2[i];
        }

        return result;
    }
}
