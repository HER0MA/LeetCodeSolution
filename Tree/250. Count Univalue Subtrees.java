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
    int res;
    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    private boolean helper(TreeNode root) {
        if (root==null) return true;
        boolean leftRes = helper(root.left);
        boolean rightRes = helper(root.right);
        if (leftRes && rightRes) {
            if (root.left!=null && root.val!=root.left.val) {
                return false;
            }
            if (root.right!=null && root.val!=root.right.val) {
                return false;
            }
            res++;
            return true;
        }
        return false;
    }
}