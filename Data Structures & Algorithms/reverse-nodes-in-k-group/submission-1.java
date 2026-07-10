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
        ListNode dummy = new ListNode(0, head);
        ListNode gPrev = dummy;

        while (true) {
            ListNode kth = getKth(gPrev, k);
            if (kth == null) {
                break;
            }
            ListNode gNext = kth.next;
            ListNode prev = kth.next, cur = gPrev.next;
            while (cur != gNext) {
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }

            ListNode tmp2 = gPrev.next;
            gPrev.next = kth;
            gPrev = tmp2;
        }
        

        return dummy.next;
    }

    private ListNode getKth(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }

        return node;
    }
}
