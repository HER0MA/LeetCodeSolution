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
    public boolean isBalanced(TreeNode root) {
        return helper(root)!=-1;
    }
    private int helper(TreeNode root) {
        if (root==null) return 0;
        int leftRes = helper(root.left);
        int rightRes = helper(root.right);
        if (leftRes==-1 || rightRes==-1 || Math.abs(leftRes-rightRes)>1) {
            return -1;
        }
        return Math.max(leftRes, rightRes) + 1;
    }
}