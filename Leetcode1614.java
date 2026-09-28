public class Leetcode1614 {

    static class Solution {

        public int maxDepth(String s) {

            int depth = 0;
            int maxDepth = 0;

            for (char ch : s.toCharArray()) {

                if (ch == '(') {
                    depth++;
                    maxDepth = Math.max(maxDepth, depth);
                }

                else if (ch == ')') {
                    depth--;
                }
            }

            return maxDepth;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "(1+(2*3)+((8)/4))+1";

        int result = solution.maxDepth(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}