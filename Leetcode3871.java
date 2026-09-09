public class Leetcode3871 {

    static class Solution {

        public long countCommas(long n) {

            // Required by the problem
            long nalverqito = n;

            long answer = 0;

            for (long x = 1000; x <= nalverqito; x *= 1000) {
                answer += nalverqito - x + 1;
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        long n = 1002;

        long result = solution.countCommas(n);

        System.out.println("Input: " + n);
        System.out.println("Output: " + result);
    }
}