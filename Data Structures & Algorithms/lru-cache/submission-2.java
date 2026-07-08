class LRUCache {
    ListNode tail;
    ListNode head;
    int capacity;
    int size;
    Map<Integer, ListNode> map;
    public LRUCache(int capacity) {
        tail = new ListNode(0);
        head = new ListNode(0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = helper(map.get(key));
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = helper(map.get(key));
            node.val = value;
        } else {
            ListNode newNode = new ListNode(value);
            newNode.key = key;
            map.put(key, newNode);
            moveToTop(newNode);
            size++;
            if (size > capacity) {
                ListNode old = head.next;
                head.next = old.next;
                old.next.prev = head;
                map.remove(old.key);
                size--;
            }
        }
    }

    private ListNode helper(ListNode node) {
        ListNode prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
        moveToTop(node);
        return node;
    }

    private void moveToTop(ListNode node) {
        ListNode prev2 = tail.prev;
        tail.prev = node;
        node.next = tail;
        node.prev = prev2;
        prev2.next = node;
    }
}

public class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    int key;

    public ListNode(int val) {
        this.val = val;
        next = null;
        prev = null;
        key = -1;
    }
}