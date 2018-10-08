/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// inorder traversal no recursion implementation
public class BSTIterator {
    private TreeNode curr;
    Stack<TreeNode> stack;
        
    public BSTIterator(TreeNode root) {
        curr = root;
        stack = new Stack<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !(stack.isEmpty() && curr==null);
    }

    /** @return the next smallest number */
    public int next() {
        while (curr!=null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        int res = curr.val;
        curr = curr.right;
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */