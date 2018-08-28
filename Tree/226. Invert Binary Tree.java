/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// t:n s:n
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        TreeNode leftRes = invertTree(root.left);
        TreeNode rightRes = invertTree(root.right);
        root.left = rightRes;
        root.right = leftRes;
        return root;
    }
}