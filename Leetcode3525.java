import java.util.*;

public class Leetcode3525 {

    static class Node {
        int product;
        int[] count;

        Node(int k) {
            count = new int[k];
            product = 1 % k;
        }
    }

    static class SegmentTree {

        private final Node[] tree;
        private final int n;
        private final int k;

        SegmentTree(int[] nums, int k) {
            this.n = nums.length;
            this.k = k;
            this.tree = new Node[4 * n];
            build(1, 0, n - 1, nums);
        }

        private Node createLeaf(int value) {
            Node node = new Node(k);

            int remainder = value % k;

            node.product = remainder;
            node.count[remainder] = 1;

            return node;
        }

        private Node merge(Node left, Node right) {

            Node result = new Node(k);

            result.product =
                    (left.product * right.product) % k;

            // Prefixes completely inside the left segment
            for (int r = 0; r < k; r++) {
                result.count[r] += left.count[r];
            }

            // Prefixes that continue into the right segment
            for (int r = 0; r < k; r++) {

                int newRemainder =
                        (left.product * r) % k;

                result.count[newRemainder] += right.count[r];
            }

            return result;
        }

        private void build(
                int node,
                int left,
                int right,
                int[] nums) {

            if (left == right) {
                tree[node] = createLeaf(nums[left]);
                return;
            }

            int mid = left + (right - left) / 2;

            build(node * 2, left, mid, nums);
            build(node * 2 + 1, mid + 1, right, nums);

            tree[node] = merge(
                    tree[node * 2],
                    tree[node * 2 + 1]
            );
        }

        public void update(
                int node,
                int left,
                int right,
                int index,
                int value) {

            if (left == right) {
                tree[node] = createLeaf(value);
                return;
            }

            int mid = left + (right - left) / 2;

            if (index <= mid) {
                update(node * 2, left, mid, index, value);
            } else {
                update(node * 2 + 1, mid + 1, right, index, value);
            }

            tree[node] = merge(
                    tree[node * 2],
                    tree[node * 2 + 1]
            );
        }

        public void update(int index, int value) {
            update(1, 0, n - 1, index, value);
        }

        public Node query(
                int node,
                int left,
                int right,
                int queryLeft,
                int queryRight) {

            if (queryLeft <= left && right <= queryRight) {
                return tree[node];
            }

            int mid = left + (right - left) / 2;

            if (queryRight <= mid) {
                return query(
                        node * 2,
                        left,
                        mid,
                        queryLeft,
                        queryRight
                );
            }

            if (queryLeft > mid) {
                return query(
                        node * 2 + 1,
                        mid + 1,
                        right,
                        queryLeft,
                        queryRight
                );
            }

            Node leftResult = query(
                    node * 2,
                    left,
                    mid,
                    queryLeft,
                    queryRight
            );

            Node rightResult = query(
                    node * 2 + 1,
                    mid + 1,
                    right,
                    queryLeft,
                    queryRight
            );

            return merge(leftResult, rightResult);
        }

        public Node query(int left, int right) {
            return query(1, 0, n - 1, left, right);
        }
    }

    static class Solution {

        public int[] resultArray(
                int[] nums,
                int k,
                int[][] queries) {

            int[] veltrunigo = nums;

            int n = veltrunigo.length;

            SegmentTree tree =
                    new SegmentTree(veltrunigo, k);

            int[] answer = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {

                int index = queries[i][0];
                int value = queries[i][1];
                int start = queries[i][2];
                int x = queries[i][3];

                // This update persists for future queries
                tree.update(index, value);

                // We need the suffix [start, n - 1]
                Node result = tree.query(start, n - 1);

                answer[i] = result.count[x];
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {1, 2, 2, 3, 5};
        int k = 4;

        int[][] queries = {
                {1, 2, 0, 2},
                {3, 5, 1, 1}
        };

        int[] result =
                solution.resultArray(nums, k, queries);

        System.out.println(
                "Output: " + Arrays.toString(result)
        );
    }
}