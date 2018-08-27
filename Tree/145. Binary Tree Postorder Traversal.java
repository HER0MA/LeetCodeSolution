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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        List<Integer> leftRes = postorderTraversal(root.left);
        List<Integer> rightRes = postorderTraversal(root.right);
        res.addAll(leftRes);
        res.addAll(rightRes);
        res.add(root.val);
        return res;
    }
}

// no recursion
// LinkedList addFirst
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode curr = stack.pop();
            res.addFirst(curr.val);
            if (curr.left!=null) stack.push(curr.left);
            if (curr.right!=null) stack.push(curr.right);
        }
        return res;
    }
}