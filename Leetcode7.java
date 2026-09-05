import java.util.*;

public class Leetcode7 {

    static class Solution {

        public int reverse(int x) {

            int result = 0;

            while (x != 0) {

                int digit = x % 10;
                x /= 10;

                // Check integer overflow before multiplying by 10
                if (result > Integer.MAX_VALUE / 10 ||
                        (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                    return 0;
                }

                if (result < Integer.MIN_VALUE / 10 ||
                        (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                    return 0;
                }

                result = result * 10 + digit;
            }

            return result;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int x = 123;

        int result = solution.reverse(x);

        System.out.println("Input: " + x);
        System.out.println("Output: " + result);
    }
}