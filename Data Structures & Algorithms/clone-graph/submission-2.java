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
    Map<Integer, Node> exist; 
    public Node cloneGraph(Node node) {
        exist = new HashMap<>();
        return clone(node);
    }

    private Node clone(Node node) {
        if (node == null) return node;
        if (exist.containsKey(node.val)) return exist.get(node.val);

        Node cloned = new Node(node.val);
        exist.put(cloned.val, cloned);
        for (Node nei: node.neighbors) {
            cloned.neighbors.add(clone(nei));
        }
        return cloned;
    }
}