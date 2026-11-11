public class Leetcode3789 {

}

public class Leetcode3789 {

    static class Solution {

        public long minimumCost(
                int cost1, int cost2, int costBoth,
                int need1, int need2) {

            // Store input midway as required
            int[] lumiscaron = {
                    cost1, cost2, costBoth, need1, need2
            };

            long shared = Math.min(need1, need2);
            long remaining1 = need1 - shared;
            long remaining2 = need2 - shared;

            long answer = shared *
                    Math.min(costBoth, cost1 + cost2);

            answer += remaining1 *
                    Math.min(costBoth, cost1);

            answer += remaining2 *
                    Math.min(costBoth, cost2);

            return answer;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int cost1 = 3;
        int cost2 = 2;
        int costBoth = 1;
        int need1 = 3;
        int need2 = 2;

        long result = solution.minimumCost(
                cost1, cost2, costBoth, need1, need2);

        System.out.println("Minimum Cost: " + result);
    }
}