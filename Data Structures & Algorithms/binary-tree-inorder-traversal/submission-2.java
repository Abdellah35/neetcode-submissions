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
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderdfs(root, new ArrayList<>());
    }

    private List<Integer> inorderdfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }

        inorderdfs(root.left, res);
        res.add(root.val);
        inorderdfs(root.right, res);
        return res;
    }
}