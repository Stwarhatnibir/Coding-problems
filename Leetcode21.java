public class Leetcode21 {

    static class ListNode {
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

    static class Solution {

        public ListNode mergeTwoLists(
                ListNode list1,
                ListNode list2) {

            // Dummy node makes handling the first node easier
            ListNode dummy = new ListNode(0);

            ListNode current = dummy;

            while (list1 != null && list2 != null) {

                if (list1.val <= list2.val) {

                    current.next = list1;
                    list1 = list1.next;

                } else {

                    current.next = list2;
                    list2 = list2.next;
                }

                current = current.next;
            }

            // Attach whatever is left
            if (list1 != null) {
                current.next = list1;
            } else {
                current.next = list2;
            }

            return dummy.next;
        }
    }

    // Helper to print linked list
    static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 4
        ListNode list1 =
                new ListNode(1,
                    new ListNode(2,
                        new ListNode(4)));

        // 1 -> 3 -> 4
        ListNode list2 =
                new ListNode(1,
                    new ListNode(3,
                        new ListNode(4)));

        Solution solution = new Solution();

        ListNode result =
                solution.mergeTwoLists(list1, list2);

        System.out.println("Merged list:");
        printList(result);
    }
}