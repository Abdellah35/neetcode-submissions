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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<Boolean> visit = new Stack<>();
        visit.push(false);
        List<Integer> res = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            boolean visited = visit.pop();
            if(cur != null) {
                if (visited) {
                    res.add(cur.val);
                } else {
                    stack.push(cur);
                    visit.push(true);
                    stack.push(cur.right);
                    visit.push(false);
                    stack.push(cur.left);
                    visit.push(false);
                }
            }
        }

        return res;
    }
}