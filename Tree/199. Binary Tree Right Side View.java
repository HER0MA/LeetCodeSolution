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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        helper(root, 0, res);
        return res;
    }
    private void helper(TreeNode root, int level, List<Integer> res) {
        if (root==null) return;
        if (level==res.size()) res.add(root.val);
        helper(root.right, level+1, res);
        helper(root.left, level+1, res);
    }
}