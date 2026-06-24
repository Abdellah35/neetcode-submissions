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
    int res;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int val = node.val;
        int l = Math.max(dfs(node.left), 0);
        int r = Math.max(dfs(node.right), 0);
        res = Math.max(res, val + l + r);
        
        return val + Math.max(l, r);
    }
}
