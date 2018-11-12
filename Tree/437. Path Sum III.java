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
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        // if map.get(preSum) = n
        // there are n root-to-descendant paths sum to preSum
        map.put(0, 1);
        // do not use any node, sum is zero
        return helper(root, 0, sum, map);
    }
    
    private int helper(TreeNode root, int currSum, int target, Map<Integer, Integer> map) {
        if (root==null) return 0;
        currSum += root.val;
        int res = map.getOrDefault(currSum-target, 0);
        
        map.put(currSum, map.getOrDefault(currSum, 0)+1);
        res += helper(root.left, currSum, target, map) + helper(root.right, currSum, target, map);
        map.put(currSum, map.get(currSum)-1); // backtracking
        
        return res;
    }
}