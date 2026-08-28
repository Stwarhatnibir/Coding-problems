import java.util.HashSet;
import java.util.Set;

class Leetcode3 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "abcabcbb";

        int result = solution.lengthOfLongestSubstring(s);

        System.out.println("Longest length = " + result);
    }
}

class Solution {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Remove characters until duplicate is gone
            while (set.contains(s.charAt(right))) {

                set.remove(s.charAt(left));

                left++;
            }

            // Add current character
            set.add(s.charAt(right));

            // Update maximum length
            maxLength = Math.max(
                    maxLength,
                    right - left + 1);
        }

        return maxLength;
    }
}