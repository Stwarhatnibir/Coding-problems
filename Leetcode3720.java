class Leetcode3720 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "abc";
        String target = "bba";

        String result = solution.lexGreaterPermutation(s, target);

        System.out.println("Result = " + result);
    }
}

class Solution {

    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        int[] count = new int[26];

        // Count characters in s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Try to match target from left to right
        for (int i = 0; i < n; i++) {

            int current = target.charAt(i) - 'a';

            // If we can match target[i], use it
            if (count[current] > 0) {
                count[current]--;
            } else {
                // Cannot match anymore, try to make
                // this position larger
                for (int j = current + 1; j < 26; j++) {
                    if (count[j] > 0) {

                        StringBuilder answer = new StringBuilder(target.substring(0, i));

                        answer.append((char) ('a' + j));

                        count[j]--;

                        // Add remaining characters in sorted order
                        for (int k = 0; k < 26; k++) {
                            while (count[k] > 0) {
                                answer.append((char) ('a' + k));
                                count[k]--;
                            }
                        }

                        return answer.toString();
                    }
                }

                break;
            }
        }

        // Backtrack and try increasing an earlier position
        for (int i = n - 1; i >= 0; i--) {

            int current = target.charAt(i) - 'a';

            // Put back the character we used
            count[current]++;

            // Find the smallest available character
            // greater than target[i]
            for (int j = current + 1; j < 26; j++) {

                if (count[j] > 0) {

                    StringBuilder answer = new StringBuilder(target.substring(0, i));

                    answer.append((char) ('a' + j));

                    count[j]--;

                    // Add remaining characters in sorted order
                    for (int k = 0; k < 26; k++) {
                        while (count[k] > 0) {
                            answer.append((char) ('a' + k));
                            count[k]--;
                        }
                    }

                    return answer.toString();
                }
            }
        }

        return "";
    }
}