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
    public int rob(TreeNode root) {
        if (root==null) return 0;
        int robRoot = root.val;
        robRoot += root.left==null ? 0 : rob(root.left.left)+rob(root.left.right);
        robRoot += root.right==null ? 0 : rob(root.right.left)+rob(root.right.right);
        int notRobRoot = rob(root.left) + rob(root.right);
        return Math.max(robRoot, notRobRoot);
    }
}