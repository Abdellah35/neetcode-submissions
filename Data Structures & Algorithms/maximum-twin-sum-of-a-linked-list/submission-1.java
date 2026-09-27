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
    public int pairSum(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = slow;

        ListNode prev = null;
        while (cur != null) {
            ListNode tmp = prev;
            prev = new ListNode(cur.val);
            prev.next = tmp;
            cur = cur.next;
        }

        ListNode left = head;
        ListNode right = prev;
        int maxSum = Integer.MIN_VALUE;
        while (right != null && left != null) {
            maxSum = Math.max(maxSum, right.val + left.val);
            right = right.next;
            left = left.next;
        }
        
       return maxSum;
    }
}