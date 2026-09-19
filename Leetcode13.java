public class Leetcode13 {

    static class Solution {

        public int romanToInt(String s) {

            int[] values = new int[128];

            values['I'] = 1;
            values['V'] = 5;
            values['X'] = 10;
            values['L'] = 50;
            values['C'] = 100;
            values['D'] = 500;
            values['M'] = 1000;

            int result = 0;

            for (int i = 0; i < s.length() - 1; i++) {

                int current = values[s.charAt(i)];
                int next = values[s.charAt(i + 1)];

                if (current < next) {
                    result -= current;
                } else {
                    result += current;
                }
            }

            // Add the last character
            result += values[s.charAt(s.length() - 1)];

            return result;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "MCMXCIV";

        int result = solution.romanToInt(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}