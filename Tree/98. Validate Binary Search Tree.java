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
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer max, Integer min) {
        if (root==null) return true;
        if (max!=null && root.val>=max || min!=null && root.val<=min) return false;
        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }
}
// one test case contains Integer.MAX_VALUE
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    private boolean helper(TreeNode root, int max, int min) {
        if (root==null) return true;
        if (root.val>=max || root.val<=min) return false;
        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }
}