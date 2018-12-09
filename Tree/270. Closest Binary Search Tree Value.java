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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        double diff = Math.abs(target - root.val);
        while (root!=null) {
            if (Math.abs(target-root.val) < diff) {
                res = root.val;
                diff = Math.abs(target - root.val);
            }
            root = root.val>target ? root.left : root.right;
        }
        return res;
    }
}