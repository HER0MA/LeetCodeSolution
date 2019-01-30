/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// t:n s:1
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }
    
    private TreeNode helper(int preIdx, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preIdx==preorder.length || inStart>inEnd) return null;
        TreeNode root = new TreeNode(preorder[preIdx]);
        int inRoot = 0;
        for (int i=inStart; i<=inEnd; i++) {
            if (inorder[i] == root.val) {
                inRoot = i;
                break;
            }
        }
        root.left = helper(preIdx+1, inStart, inRoot-1, preorder, inorder);
        // number of nodes in left subtree is (inRoot-inStart)
        root.right = helper(preIdx+inRoot-inStart+1, inRoot+1, inEnd, preorder, inorder);
        return root;
    }
}