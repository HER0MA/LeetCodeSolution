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
    private int count;
    private int res;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    
    private void helper(TreeNode root) {
        if (root==null) return;
        helper(root.left);
        count --;
        if (count==0) {
            res = root.val;
            return;
        }
        helper(root.right);
    }
}