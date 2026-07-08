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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = 0;
            if (sum > 9) {
                carry = sum / 10;
            }
            cur.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = 0;
            if (sum > 9) {
                carry = sum / 10;
            }
            cur.next = new ListNode(sum % 10);
            l1 = l1.next;
            cur = cur.next;
        }
        
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = 0;
            if (sum > 9) {
                carry = sum / 10;
            }
            cur.next = new ListNode(sum % 10);
            l2 = l2.next;
            cur = cur.next;
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
