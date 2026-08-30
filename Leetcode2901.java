import java.util.*;

class Leetcode2901 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String[] words = {
                "abcd",
                "abed",
                "acbd",
                "acdd"
        };

        int[] groups = {
                1,
                2,
                1,
                2
        };

        List<String> result = solution.getWordsInLongestSubsequence(words, groups);

        System.out.println(result);
    }
}

class Solution {

    public List<String> getWordsInLongestSubsequence(
            String[] words,
            int[] groups) {

        int n = words.length;

        // dp[i] = longest valid subsequence
        // ending at index i
        int[] dp = new int[n];

        // parent[i] = previous index
        // used to construct the answer
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int bestIndex = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                // Groups must be different
                if (groups[i] == groups[j]) {
                    continue;
                }

                // Words must have same length
                if (words[i].length() != words[j].length()) {
                    continue;
                }

                // They must differ by exactly one character
                if (!differentByOne(words[i], words[j])) {
                    continue;
                }

                // Can extend subsequence ending at j
                if (dp[j] + 1 > dp[i]) {

                    dp[i] = dp[j] + 1;

                    parent[i] = j;
                }
            }

            if (dp[i] > dp[bestIndex]) {
                bestIndex = i;
            }
        }

        // Reconstruct answer
        List<String> result = new ArrayList<>();

        int current = bestIndex;

        while (current != -1) {

            result.add(words[current]);

            current = parent[current];
        }

        // We reconstructed backwards
        Collections.reverse(result);

        return result;
    }

    private boolean differentByOne(
            String a,
            String b) {

        int difference = 0;

        for (int i = 0; i < a.length(); i++) {

            if (a.charAt(i) != b.charAt(i)) {

                difference++;

                if (difference > 1) {
                    return false;
                }
            }
        }

        return difference == 1;
    }
}