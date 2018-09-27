/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int maxLen;
    public int longestUnivaluePath(TreeNode root) {
        maxLen = 1;
        helper(root);
        return maxLen-1;
    }
    private int helper(TreeNode root) {
        if (root==null) return 0;
        int len = 1;
        // res store leaf to root length
        int res = 1;
        // helper must be run even if left/right have diff value with root
        int leftRes = helper(root.left);
        int rightRes = helper(root.right);
        if (root.left!=null && root.left.val==root.val) {
            len += leftRes;
            res += leftRes;
        }
        if (root.right!=null && root.right.val==root.val) {
            len += rightRes;
            res = Math.max(res, 1+rightRes);
        }
        maxLen = Math.max(maxLen, len);
        return res;
    }
}