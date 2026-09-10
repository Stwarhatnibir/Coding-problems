public class Leetcode2265 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {

        private int answer = 0;

        public int averageOfSubtree(TreeNode root) {
            dfs(root);
            return answer;
        }

        // Returns {sum, count} of the subtree
        private int[] dfs(TreeNode root) {

            if (root == null) {
                return new int[] { 0, 0 };
            }

            int[] left = dfs(root.left);
            int[] right = dfs(root.right);

            int sum = left[0] + right[0] + root.val;
            int count = left[1] + right[1] + 1;

            if (sum / count == root.val) {
                answer++;
            }

            return new int[] { sum, count };
        }
    }

    public static void main(String[] args) {

        /*
         * 4
         * / \
         * 8 5
         * / \ \
         * 0 1 6
         */

        TreeNode root = new TreeNode(
                4,
                new TreeNode(
                        8,
                        new TreeNode(0),
                        new TreeNode(1)),
                new TreeNode(
                        5,
                        null,
                        new TreeNode(6)));

        Solution solution = new Solution();

        int result = solution.averageOfSubtree(root);

        System.out.println("Output: " + result);
    }
}