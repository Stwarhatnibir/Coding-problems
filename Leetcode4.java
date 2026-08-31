import java.util.*;

class Leetcode4 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        double result =
                solution.findMedianSortedArrays(nums1, nums2);

        System.out.println("Median = " + result);
    }
}


class Solution {

    public double findMedianSortedArrays(
            int[] nums1,
            int[] nums2) {

        // Always binary search the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while (left <= right) {

            int partition1 =
                    left + (right - left) / 2;

            int partition2 =
                    (m + n + 1) / 2 - partition1;

            int left1 =
                    (partition1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];

            int right1 =
                    (partition1 == m)
                    ? Integer.MAX_VALUE
                    : nums1[partition1];

            int left2 =
                    (partition2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];

            int right2 =
                    (partition2 == n)
                    ? Integer.MAX_VALUE
                    : nums2[partition2];

            // Correct partition
            if (left1 <= right2 &&
                left2 <= right1) {

                // Even number of elements
                if ((m + n) % 2 == 0) {

                    return (
                        Math.max(left1, left2)
                        + Math.min(right1, right2)
                    ) / 2.0;

                } else {

                    // Odd number of elements
                    return Math.max(left1, left2);
                }
            }

            // Too many elements taken from nums1
            if (left1 > right2) {

                right = partition1 - 1;

            } else {

                // Too few elements taken from nums1
                left = partition1 + 1;
            }
        }

        return 0.0;
    }
}