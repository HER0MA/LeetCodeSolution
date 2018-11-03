/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// t:n s:1
class Solution {
    private int res;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null) return 0;
        res = 0;
        helper(root);
        return res-1;
    }
    private int helper(TreeNode root) {
        if (root==null)  return 0;
        int leftRes = helper(root.left);
        int rightRes = helper(root.right);
        res = Math.max(res, leftRes+rightRes+1);
        return Math.max(leftRes, rightRes) + 1;
    }
}