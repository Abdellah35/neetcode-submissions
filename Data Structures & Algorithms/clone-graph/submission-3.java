/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> oldToNew = new HashMap<>();
        Deque<Node> q = new ArrayDeque<>();
        oldToNew.put(node, new Node(node.val));

        q.add(node);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            Node newNode = oldToNew.get(cur);
            for (Node nei: cur.neighbors) {
                if (oldToNew.containsKey(nei)) {
                    newNode.neighbors.add(oldToNew.get(nei));
                } else {
                    Node newNei = new Node(nei.val);
                    oldToNew.put(nei, newNei);
                    newNode.neighbors.add(newNei);
                    q.add(nei);
                }
            }
        }

        return oldToNew.get(node);
    }
}