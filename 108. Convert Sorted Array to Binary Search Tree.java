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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        if(nums.length==1) {
            TreeNode ans = new TreeNode(nums[0]);
            ans.left = null;
            ans.right = null;
            return ans;
        }
        int len = nums.length;
        TreeNode ans = new TreeNode(nums[(len+1)/2 -1]); //index和第几个 差1
        int[] numPartOne = new int[len/2-(len+1)%2];
        int[] numPartTwo = new int[len/2];
        for(int i=0; i<len/2-(len+1)%2; i++){
            numPartOne[i] = nums[i];
        }
        for(int i=0; i<len/2; i++){
            numPartTwo[i] = nums[i+(len+1)/2];
        }
        ans.left = sortedArrayToBST(numPartOne);
        ans.right = sortedArrayToBST(numPartTwo);
        
        return ans;
    }
}