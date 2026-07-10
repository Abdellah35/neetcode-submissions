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
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxPrev) {
        if (node == null) return 0;
        int count = 0;
        if (node.val >= maxPrev) {
            count += 1;
        }
        maxPrev = Math.max(maxPrev, node.val);
        count += dfs(node.left, maxPrev);
        count += dfs(node.right, maxPrev);
        
        return count;
    }
}
