class Leetcode3116 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] coins = { 2, 3 };
        int k = 5;

        long result = solution.findKthSmallest(coins, k);

        System.out.println("Kth smallest amount = " + result);
    }
}

class Solution {

    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = 1_000_000_000_000_000_000L;

        while (low < high) {

            long mid = low + (high - low) / 2;

            long count = count(mid, coins);

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {

        int n = coins.length;
        long total = 0;

        // Check every non-empty subset
        for (int mask = 1; mask < (1 << n); mask++) {

            long currentLCM = 1;
            int bits = 0;
            boolean tooLarge = false;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    long g = gcd(currentLCM, coins[i]);

                    // Prevent overflow
                    if (currentLCM > x / (coins[i] / g)) {
                        tooLarge = true;
                        break;
                    }

                    currentLCM = currentLCM / g * coins[i];
                }
            }

            if (tooLarge || currentLCM > x) {
                continue;
            }

            long multiples = x / currentLCM;

            // Odd number of coins -> add
            if (bits % 2 == 1) {
                total += multiples;
            }
            // Even number of coins -> subtract
            else {
                total -= multiples;
            }
        }

        return total;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}