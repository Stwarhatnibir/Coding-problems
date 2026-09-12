import java.util.*;

public class Leetcode3414 {

    static class Interval {
        int left;
        int right;
        int weight;
        int index;

        Interval(int left, int right, int weight, int index) {
            this.left = left;
            this.right = right;
            this.weight = weight;
            this.index = index;
        }
    }

    static class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    static class Solution {

        public int[] maximumWeight(List<List<Integer>> intervals) {
            int n = intervals.size();

            Interval[] arr = new Interval[n];

            for (int i = 0; i < n; i++) {
                arr[i] = new Interval(
                        intervals.get(i).get(0),
                        intervals.get(i).get(1),
                        intervals.get(i).get(2),
                        i);
            }

            // Sort by right endpoint
            Arrays.sort(arr, (a, b) -> {
                if (a.right != b.right) {
                    return Integer.compare(a.right, b.right);
                }
                return Integer.compare(a.left, b.left);
            });

            int[] ends = new int[n];

            for (int i = 0; i < n; i++) {
                ends[i] = arr[i].right;
            }

            // dp[k][i] = best result using at most k intervals
            // among first i intervals
            State[][] dp = new State[5][n + 1];

            for (int k = 0; k <= 4; k++) {
                dp[k][0] = new State(0, new int[0]);
            }

            for (int i = 1; i <= n; i++) {

                Interval current = arr[i - 1];

                // First interval: no intervals selected
                for (int k = 0; k <= 4; k++) {
                    dp[k][i] = dp[k][i - 1];
                }

                // Find last interval whose right < current.left
                int previous = upperBound(ends, current.left - 1);

                for (int k = 1; k <= 4; k++) {

                    State skip = dp[k][i - 1];
                    State previousState = dp[k - 1][previous];

                    int[] newIndices = Arrays.copyOf(
                            previousState.indices,
                            previousState.indices.length + 1);

                    newIndices[newIndices.length - 1] = current.index;

                    Arrays.sort(newIndices);

                    State take = new State(
                            previousState.score + current.weight,
                            newIndices);

                    dp[k][i] = better(skip, take);
                }
            }

            return dp[4][n].indices;
        }

        // First position whose value is > target
        private int upperBound(int[] arr, int target) {
            int left = 0;
            int right = arr.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }

        private State better(State a, State b) {

            if (a.score != b.score) {
                return a.score > b.score ? a : b;
            }

            // Same score -> lexicographically smaller indices
            return compareLexicographically(a.indices, b.indices) <= 0
                    ? a
                    : b;
        }

        private int compareLexicographically(int[] a, int[] b) {
            int n = Math.min(a.length, b.length);

            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) {
                    return Integer.compare(a[i], b[i]);
                }
            }

            return Integer.compare(a.length, b.length);
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> intervals = Arrays.asList(
                Arrays.asList(1, 3, 2),
                Arrays.asList(4, 5, 2),
                Arrays.asList(1, 5, 5),
                Arrays.asList(6, 9, 3),
                Arrays.asList(6, 7, 1),
                Arrays.asList(8, 9, 1));

        Solution solution = new Solution();

        int[] result = solution.maximumWeight(intervals);

        System.out.println("Output: " + Arrays.toString(result));
    }
}