/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copies = new HashMap<>();
        Node cur = head;

        while(cur != null) {
            Node copy = new Node(cur.val);
            copies.put(cur, copy);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node copy = copies.get(cur);
            copy.next = copies.getOrDefault(cur.next, null);
            copy.random = copies.getOrDefault(cur.random, null);
            cur = cur.next;
        }

        return copies.getOrDefault(head, null);
    }
}
