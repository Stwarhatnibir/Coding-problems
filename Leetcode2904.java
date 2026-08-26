class Leetcode2904 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "100011001";
        int k = 3;

        String result = solution.shortestBeautifulSubstring(s, k);

        System.out.println("Result = " + result);
    }
}


class Solution {

    public String shortestBeautifulSubstring(String s, int k) {

        int left = 0;
        int ones = 0;

        String answer = "";

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            if (s.charAt(right) == '1') {
                ones++;
            }

            // Too many 1s, shrink from left
            while (ones > k) {

                if (s.charAt(left) == '1') {
                    ones--;
                }

                left++;
            }

            // Remove unnecessary leading zeros
            while (ones == k && left < right
                    && s.charAt(left) == '0') {

                left++;
            }

            // We have exactly k ones
            if (ones == k) {

                String current = s.substring(left, right + 1);

                // Check if it is shorter
                if (answer.equals("")
                        || current.length() < answer.length()) {

                    answer = current;
                }

                // Same length -> lexicographically smaller
                else if (current.length() == answer.length()
                        && current.compareTo(answer) < 0) {

                    answer = current;
                }
            }
        }

        return answer;
    }
}