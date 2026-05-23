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

class Solution {
    public boolean isValidBST(TreeNode root) {
        return correct(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean correct(TreeNode node, long left, long right) {
        if (node == null) return true;
        if (!(left < node.val && right > node.val)) {
            return false;
        }

        return correct(node.left, left, node.val) && correct(node.right, node.val, right);
    }
}
