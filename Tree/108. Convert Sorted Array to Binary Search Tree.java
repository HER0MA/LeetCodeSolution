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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) return null;
        return helper(0, nums.length-1, nums);
    }
    private TreeNode helper(int left, int right, int[] nums) {
        if (left==right) return new TreeNode(nums[left]);
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        // if left+1==right left=mid
        if (left!=mid) root.left = helper(left, mid-1, nums);
        root.right = helper(mid+1, right, nums);
        return root;
    }
}