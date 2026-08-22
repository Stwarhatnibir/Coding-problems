class Leetcode3622 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int n = 99;

        boolean result = solution.checkDivisibility(n);

        System.out.println(result);
    }
}

class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;

        int x = n;

        while (x != 0) {
            int digit = x % 10;

            sum += digit;
            product *= digit;

            x /= 10;
        }

        return n % (sum + product) == 0;
    }
}