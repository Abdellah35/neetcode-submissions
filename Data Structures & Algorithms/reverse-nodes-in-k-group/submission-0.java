/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        int count = 0;
        ListNode node = head;
        while (count < k &&node != null) {
            node = node.next;
            count++;
        }

        if (count == k) {
            ListNode prev = null;
            ListNode next = null;
            ListNode tmpCur = head;

            for (int i = 0; i < k; i++) {
                next = tmpCur.next;
                tmpCur.next = prev;
                prev = tmpCur;
                tmpCur = next;
            }

            if (next != null) {
                head.next = reverseKGroup(next, k);
            }

            return prev;
        }

        return head;
    }
}
