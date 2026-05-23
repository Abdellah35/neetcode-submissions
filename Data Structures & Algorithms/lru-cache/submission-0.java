class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;

    }
}
class LRUCache {
    int cap;
    HashMap<Integer, ListNode> cache;
    ListNode left;
    ListNode right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new ListNode(0, 0);
        this.right = new ListNode(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if (this.cache.containsKey(key)) {
            remove(this.cache.get(key));
            insert(this.cache.get(key));
            return this.cache.get(key).val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            remove(this.cache.get(key));
        }

        this.cache.put(key, new ListNode(key, value));
        insert(this.cache.get(key));

        if (this.cache.size() > this.cap) {
            ListNode lru = this.left.next;
            remove(lru);
            this.cache.remove(lru.key);
        }
    }

    private void remove(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(ListNode node) {
        ListNode prev = this.right.prev;
        ListNode next = this.right;
        prev.next = node;
        next.prev = node;
        node.prev = prev;
        node.next = next;
    }
}
