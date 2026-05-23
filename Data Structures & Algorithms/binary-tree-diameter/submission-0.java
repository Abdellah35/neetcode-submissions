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

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxDiameter;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int leftmax = helper(root.left);
        int rightmax = helper(root.right);

        maxDiameter = Math.max(maxDiameter, leftmax + rightmax);
        return Math.max(leftmax, rightmax) + 1;
    }
}
