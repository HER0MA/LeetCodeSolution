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
    private int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }
    // helper returns the maximum leaf to current node path sum
    private int helper(TreeNode root) {
        if (root==null) return 0;
        // helper returns may be negative
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res = Math.max(res, left+right+root.val);
        return Math.max(left, right) + root.val;
    }
}

class Solution {
    class resType {
        int maxCurr;
        int maxAll;
        resType(int curr, int all) {
            maxCurr = curr;
            maxAll = all;
        }
    }
    public int maxPathSum(TreeNode root) {
        return maxPathHelper(root).maxAll;
    }
    private resType maxPathHelper(TreeNode root) {
        if (root == null) return new resType(Integer.MIN_VALUE,Integer.MIN_VALUE);
        resType left = maxPathHelper(root.left);
        resType right = maxPathHelper(root.right);
        int leftCurr = left.maxCurr > 0 ? left.maxCurr : 0;
        int rightCurr = right.maxCurr > 0 ? right.maxCurr : 0;
        int currMax = Math.max(leftCurr, rightCurr) + root.val;
        int allMax = Math.max(left.maxAll, right.maxAll);
        allMax = Math.max(allMax, leftCurr + root.val + rightCurr);
        return new resType(currMax, allMax);
    }
}