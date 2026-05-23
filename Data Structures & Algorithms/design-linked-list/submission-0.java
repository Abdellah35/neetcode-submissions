public class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int val) {
        this.val = val;
        next = null;
        prev = null;
    }
}
class MyLinkedList {
    ListNode tail;
    ListNode head;

    public MyLinkedList() {
        tail = new ListNode(0);
        head = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int index) {
        ListNode curr = head.next;
        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }
        if (curr != null && curr != tail && index == 0) {
            return curr.val;
        }

        return -1;
    }
    
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        ListNode next = head.next;
        ListNode prev = head;
        next.prev = node;
        prev.next = node;
        node.next = next;
        node.prev = prev;
    }
    
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode next = tail;
        ListNode prev = tail.prev;
        next.prev = node;
        prev.next = node;
        node.next = next;
        node.prev = prev;
    }
    
    public void addAtIndex(int index, int val) {
        ListNode curr = head.next;

        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }

        if (curr != null && index == 0) {
            ListNode node = new ListNode(val);
            ListNode next = curr;
            ListNode prev = curr.prev;
            next.prev = node;
            prev.next = node;
            node.next = next;
            node.prev = prev;
        }

    }
    
    public void deleteAtIndex(int index) {
        ListNode curr = head.next;

        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }

        if (curr != null && curr != tail && index == 0) {
            ListNode next = curr.next;
            ListNode prev = curr.prev;
            next.prev = prev;
            prev.next = next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */