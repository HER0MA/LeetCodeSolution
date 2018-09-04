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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    // helper return level of node
    // leaf node has level 0
    // level of a node is only related to its children
    // this node should be removed in (level + 1) operation
    private int helper(TreeNode root, List<List<Integer>> res) {
        if (root==null) return -1;
        int leftLevel = helper(root.left, res);
        int rightLevel = helper(root.right, res);
        // level matches index of res
        int level = Math.max(leftLevel, rightLevel)+1;
        if (res.size()==level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        return level;
    }
}