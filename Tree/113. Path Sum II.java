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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, new ArrayList<>(), res);
        return res;
    }
    private void helper(TreeNode root, int sum, List<Integer> curr, List<List<Integer>> res) {
        if (root==null) return;
        curr.add(root.val);
        if (root.right==null && root.left==null && root.val==sum) {   
            res.add(new ArrayList<>(curr));
            curr.remove(curr.size()-1);
            return;
        }
        helper(root.left, sum-root.val, curr, res);
        helper(root.right, sum-root.val, curr, res);
        curr.remove(curr.size()-1);
    }
}