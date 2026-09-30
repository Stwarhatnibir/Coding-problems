public class Leetcode1111 {

    static class Solution {

        public int[] maxDepthAfterSplit(String seq) {

            int n = seq.length();
            int[] answer = new int[n];

            int depth = 0;

            for (int i = 0; i < n; i++) {

                if (seq.charAt(i) == '(') {
                    depth++;
                    answer[i] = depth % 2;
                } else {
                    answer[i] = depth % 2;
                    depth--;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String seq = "(()())";

        int[] result = solution.maxDepthAfterSplit(seq);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}