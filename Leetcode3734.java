class Leetcode3734 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "baba";
        String target = "abba";

        String result =
                solution.lexPalindromicPermutation(s, target);

        System.out.println("Result = " + result);
    }
}


class Solution {

    public String lexPalindromicPermutation(
            String s,
            String target) {

        int n = s.length();

        int[] count = new int[26];

        // Count characters
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Check if palindrome is possible
        int oddCount = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {

            if (count[i] % 2 == 1) {
                oddCount++;
                middle = (char) ('a' + i);
            }
        }

        // More than one odd character
        // means palindrome is impossible
        if (oddCount > 1) {
            return "";
        }

        // Count characters for left half
        int[] halfCount = new int[26];

        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        StringBuilder left = new StringBuilder();

        int halfLength = n / 2;

        // Build the left half
        for (int pos = 0; pos < halfLength; pos++) {

            boolean found = false;

            // Try smallest character first
            for (int c = 0; c < 26; c++) {

                if (halfCount[c] == 0) {
                    continue;
                }

                // Use this character temporarily
                halfCount[c]--;
                left.append((char) ('a' + c));

                // Check whether we can still
                // create a palindrome > target
                if (canMakeGreater(
                        left,
                        halfCount,
                        middle,
                        target)) {

                    found = true;
                    break;
                }

                // Undo the choice
                left.deleteCharAt(left.length() - 1);
                halfCount[c]++;
            }

            // No valid character found
            if (!found) {
                return "";
            }
        }

        // Build final palindrome
        StringBuilder answer =
                new StringBuilder(left);

        if (n % 2 == 1) {
            answer.append(middle);
        }

        answer.append(
                new StringBuilder(left).reverse()
        );

        return answer.toString();
    }


    private boolean canMakeGreater(
            StringBuilder prefix,
            int[] halfCount,
            char middle,
            String target) {

        StringBuilder left =
                new StringBuilder(prefix);

        // Add remaining characters from largest
        // to smallest to create the largest
        // possible palindrome for this prefix
        for (int i = 25; i >= 0; i--) {

            for (int j = 0;
                 j < halfCount[i];
                 j++) {

                left.append(
                        (char) ('a' + i)
                );
            }
        }

        StringBuilder palindrome =
                new StringBuilder(left);

        if (middle != 0) {
            palindrome.append(middle);
        }

        palindrome.append(
                new StringBuilder(left).reverse()
        );

        return palindrome.toString()
                .compareTo(target) > 0;
    }
}