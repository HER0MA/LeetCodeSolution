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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        List<Integer> leftRes = inorderTraversal(root.left);
        List<Integer> rightRes = inorderTraversal(root.right);
        res.addAll(leftRes);
        res.add(root.val);
        res.addAll(rightRes);
        return res;
    }
}

// no recursion
/**
 * for any given p
 * 1) if left!=null, then push p to stack and let p=p.left
 * 2) if left==null, then pop a treeNode from stack, 
 *    visit this treeNode and let p= this treeNode's right child
 * 3) ends when stack is empty and p=null
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.empty() || p!=null) {
            while (p!=null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.empty()) {
                p = stack.pop();
                res.add(p.val);
                p = p.right;
            }
        }
        return res;
    }
}