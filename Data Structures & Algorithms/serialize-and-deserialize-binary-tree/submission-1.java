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
    int i;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        inorder(root, sb);
        return sb.toString();
    }

    private void inorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append('n').append(',');
            return;
        }
        sb.append(node.val).append(',');
        inorder(node.left, sb);
        inorder(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] vals = data.split(",\\s*");
        i = 0;
        return build(vals);
    }

    private TreeNode build(String[] vals) {
        if (vals[i].equals("n")) {
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[i++]));
        node.left = build(vals);
        node.right = build(vals);

        return node;
    }
}
