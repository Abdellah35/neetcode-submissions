/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        List<Integer> compute = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                compute.add(null);
            } else {
                compute.add(node.val);
                q.add(node.left);
                q.add(node.right);
            }
        }
        return compute.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(", ");
        if (nodes[0] == "null") return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < nodes.length) {
            TreeNode parent = q.poll();
            if (!nodes[i].equals("null")) {
                parent.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(parent.left);
            }
            if (!nodes[i + 1].equals("null")) {
                parent.right = new TreeNode(Integer.parseInt(nodes[i + 1]));
                q.add(parent.right);
            }
            i += 2;
        }
        return root;
    }
}
