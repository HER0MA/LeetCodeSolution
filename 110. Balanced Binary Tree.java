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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return  Math.abs(depth(root.left)-depth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }// reverse the order will make the java.lang.StackOverflowError

    public int depth(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(depth(root.left),depth(root.right));
    }
}