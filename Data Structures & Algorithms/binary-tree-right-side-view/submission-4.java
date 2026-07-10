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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.push(root);

        while (!q.isEmpty()) {
            int level = q.size();
            int end = 0;
            for (int i = 0; i < level; i++) {
                TreeNode cur = q.pollLast();
                if (cur.left != null) {
                    q.push(cur.left);
                }
                if (cur.right != null) {
                    q.push(cur.right);
                }
                end = cur.val;
            }
            res.add(end);
        }

        return res;
    }
}
