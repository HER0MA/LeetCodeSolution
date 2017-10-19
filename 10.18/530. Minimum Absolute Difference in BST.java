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
    public int getMinimumDifference(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return Integer.MAX_VALUE;
        int leftAns = Integer.MAX_VALUE;
        if(root.left!=null){
            TreeNode leftSearch = root.left;
            int leftMax = -Integer.MAX_VALUE;
            while(leftSearch!=null){
                if(leftSearch.val > leftMax) leftMax = leftSearch.val;
                leftSearch = leftSearch.right;
            }
             leftAns = root.val - leftMax;
            if(leftAns==1) return 1;
        }
        int rightAns = Integer.MAX_VALUE;
        if(root.right!=null){
            TreeNode rightSearch = root.right;
            int rightMin = Integer.MAX_VALUE;;
            while(rightSearch!=null){
                if(rightSearch.val < rightMin) rightMin = rightSearch.val;
                rightSearch = rightSearch.left;
            }
            rightAns = rightMin - root.val;
            if(rightAns==1) return 1;
        }
        return Math.min(Math.min(leftAns, rightAns),Math.min(getMinimumDifference(root.right),getMinimumDifference(root.left)));
    }
}