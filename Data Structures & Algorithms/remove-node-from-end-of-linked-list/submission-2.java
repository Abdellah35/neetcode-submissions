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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        int l = length - n;
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        cur = dumy;
        while (cur != null) {
            if (l == 0) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
            l--;
        }

        return dumy.next;

    }
}
