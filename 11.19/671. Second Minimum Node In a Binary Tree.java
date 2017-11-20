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
    private int second;
    public int findSecondMinimumValue(TreeNode root) {
        second = Integer.MAX_VALUE;
        findSecondHelper(root);
        return second==Integer.MAX_VALUE ? -1 : second;     
    }
    private void findSecondHelper(TreeNode root) {
        if (root == null || root.left==null) return;
        if (root.right.val > root.left.val) {
            if(root.right.val < second) second = root.right.val;
            findSecondHelper(root.left);
        } else if (root.left.val > root.right.val) {
            if(root.left.val < second) second = root.left.val;
            findSecondHelper(root.right);
        } else {
            findSecondHelper(root.left);
            findSecondHelper(root.right);
        }
    }
}