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
    private int res;
    public int longestConsecutive(TreeNode root) {
        res = 0;
        if (root!=null) {
            helper(root, root.val, 0);
        }
        return res;
    }
    private void helper(TreeNode root, int target, int len) {
        if (root==null) return;
        len = root.val==target ? len+1 : 1;
        res = Math.max(res, len);
        helper(root.left, root.val+1, len);
        helper(root.right, root.val+1, len);
    }
}