import java.util.*;

public class Leetcode3483 {

    static class Solution {

        public int totalNumbers(int[] digits) {

            Set<Integer> numbers = new HashSet<>();

            int n = digits.length;

            for (int i = 0; i < n; i++) {

                // Last digit must be even
                if (digits[i] % 2 != 0) {
                    continue;
                }

                for (int j = 0; j < n; j++) {

                    if (i == j) {
                        continue;
                    }

                    for (int k = 0; k < n; k++) {

                        if (k == i || k == j) {
                            continue;
                        }

                        // First digit cannot be 0
                        if (digits[k] == 0) {
                            continue;
                        }

                        int number =
                            digits[k] * 100 +
                            digits[j] * 10 +
                            digits[i];

                        numbers.add(number);
                    }
                }
            }

            return numbers.size();
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] digits = {1, 2, 3, 4};

        int result = solution.totalNumbers(digits);

        System.out.println("Input: " + Arrays.toString(digits));
        System.out.println("Output: " + result);
    }
}