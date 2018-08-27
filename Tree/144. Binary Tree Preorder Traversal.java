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
// recursion
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        res.add(root.val);
        List<Integer> leftRes = preorderTraversal(root.left);
        List<Integer> rightRes = preorderTraversal(root.right);
        res.addAll(leftRes);
        res.addAll(rightRes);
        return res;
    }
}

// no recursion
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.right!=null) {
                stack.push(curr.right);
            }
            if (curr.left!=null) {
                stack.push(curr.left);
            }
        }
        return res;
    }
}