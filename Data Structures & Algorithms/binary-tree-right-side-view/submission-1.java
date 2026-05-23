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

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int dequeL = deque.size();
            int val = deque.peekLast().val;
            for (int i=0; i<dequeL; i++) {
                TreeNode curr = deque.removeFirst();
                if (curr.left != null) {
                    deque.add(curr.left);
                } 
                if (curr.right != null) {
                    deque.add(curr.right);
                }
            }
            res.add(val);
        }

        return res;
    }
}
