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
// Morris Traversal
// t:n s:1
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null) return res;
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val); // visit curr
                curr = curr.right; // move to next Node should visit
            } else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr; // set connection of left subtree to root
                    curr = curr.left;
                } else {
                    // left subtree of curr has been visited
                    prev.right = null; // disconnect
                    res.add(curr.val); // visit curr
                    curr = curr.right; // move to next Node should visit
                }
            }
        }
        return res;
    }
}