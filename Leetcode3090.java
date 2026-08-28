class Leetcode3090 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "bcbbbcba";

        int result = solution.maximumLengthSubstring(s);

        System.out.println("Maximum length = " + result);
    }
}

class Solution {

    public int maximumLengthSubstring(String s) {

        int[] count = new int[26];

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            count[current - 'a']++;

            // If this character appears more than 2 times,
            // shrink the window
            while (count[current - 'a'] > 2) {

                char leftChar = s.charAt(left);

                count[leftChar - 'a']--;

                left++;
            }

            int length = right - left + 1;

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}