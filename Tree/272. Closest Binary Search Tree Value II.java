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
// inorder traversal to get sorted values
// when the list size is enough, compare smaller one and current one
// if the smaller one is closer to target, stops
// else remove the smaller one and add current one
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(root, target, k, res);
        return res;
    }
    
    private void helper(TreeNode root, double target, int k, LinkedList<Integer> res) {
        if (root==null) return;
        helper(root.left, target, k, res);
        if (res.size()==k) {
            if (Math.abs(res.peekFirst()-target) >  Math.abs(root.val-target)) {
                res.removeFirst();
            } else return;
        }
        res.add(root.val);
        helper(root.right, target, k, res);
    }
}