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
    public int findSecondMinimumValue(TreeNode root) {
        if (root.left==null) return -1;
        int left = root.left.val==root.val ? findSecondMinimumValue(root.left) : root.left.val;
        int right = root.right.val==root.val ? findSecondMinimumValue(root.right) : root.right.val;
        if (left!=-1 && right!=-1) {
            return Math.min(left, right);
        } else if (left==-1) {
            return right;
        } else {
            return left;
        }
    }
}