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
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isTwoTreeSymmetric(root.left, root.right);
    }
    private boolean isTwoTreeSymmetric(TreeNode r1, TreeNode r2) {
        if (r1==null && r2==null) return true;
        if (r1==null || r2==null) return false;
        if (r1.val != r2.val) return false;
        return isTwoTreeSymmetric(r1.left, r2.right) && isTwoTreeSymmetric(r1.right, r2.left);
    }
}