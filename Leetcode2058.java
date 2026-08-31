class Leetcode2058 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // [5, 3, 1, 2, 5, 1, 2]

        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);

        int[] result =
                solution.nodesBetweenCriticalPoints(head);

        System.out.println(
                "Minimum distance = " + result[0]
        );

        System.out.println(
                "Maximum distance = " + result[1]
        );
    }
}


class ListNode {

    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class Solution {

    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int last = -1;
        int minDist = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        while (curr != null && curr.next != null) {

            int a = prev.val;
            int b = curr.val;
            int c = curr.next.val;

            if ((b > a && b > c) ||
                (b < a && b < c)) {

                if (first == -1) {
                    first = index;
                } else {
                    minDist = Math.min(
                            minDist,
                            index - last
                    );
                }

                last = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }

        int maxDist = last - first;

        return new int[]{minDist, maxDist};
    }
}