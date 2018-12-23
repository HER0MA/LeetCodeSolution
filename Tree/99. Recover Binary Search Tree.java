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
    private TreeNode prev;
    private TreeNode first;
    private TreeNode second;
    
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        prev = null;
        first = null;
        second = null;
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    // inorder traversal
    private void helper(TreeNode root) {
        if (root==null) return;
        helper(root.left);
        if (prev!=null && prev.val>root.val) {
            // first is prev and second is root
            if (first==null) first = prev;
            // corner case: prev is first root is second
            second = root;
        }
        prev = root;
        helper(root.right);
    }
}