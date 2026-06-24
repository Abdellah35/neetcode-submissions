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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        int mid = preorder[0];
        int indx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == mid) {
                indx = i;
                break;
            }
        }
        TreeNode node = new TreeNode(mid);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, indx + 1);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, indx + 1);
        node.left = buildTree(preLeft, inLeft);
        int[] inRight = Arrays.copyOfRange(inorder, indx + 1, inorder.length);
        int[] preRight = Arrays.copyOfRange(preorder, indx + 1, preorder.length);
        node.right = buildTree(preRight, inRight);
        return node;
    }
}
