import java.util.*;

public class Leetcode5 {

    static class Solution {

        public String longestPalindrome(String s) {

            if (s == null || s.length() < 2) {
                return s;
            }

            int start = 0;
            int maxLength = 1;

            for (int i = 0; i < s.length(); i++) {

                // Odd length palindrome
                int len1 = expandFromCenter(s, i, i);

                // Even length palindrome
                int len2 = expandFromCenter(s, i, i + 1);

                int len = Math.max(len1, len2);

                if (len > maxLength) {
                    maxLength = len;

                    start = i - (len - 1) / 2;
                }
            }

            return s.substring(start, start + maxLength);
        }

        private int expandFromCenter(String s, int left, int right) {

            while (left >= 0 &&
                    right < s.length() &&
                    s.charAt(left) == s.charAt(right)) {

                left--;
                right++;
            }

            return right - left - 1;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "babad";

        String result = solution.longestPalindrome(s);

        System.out.println("Input: " + s);
        System.out.println("Longest Palindromic Substring: " + result);
    }
}