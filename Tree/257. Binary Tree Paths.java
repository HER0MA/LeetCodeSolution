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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root==null) return res;
        helper(root, "", res);
        return res;
    }
    private void helper(TreeNode root, String str, List<String> res) {
        if (root.left==null && root.right==null) {
            res.add(str+root.val);
            return;
        }
        if (root.left!=null) {
            helper(root.left, str+root.val+"->", res);
        }
        if (root.right!=null) {
            helper(root.right, str+root.val+"->", res);
        }
    }
}


class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root==null) return res;
        helper(root, new StringBuilder(), res);
        return res;
    }
    private void helper(TreeNode root, StringBuilder sb, List<String> res) {
        int len = String.valueOf(root.val).length();
        sb.append(root.val);
        if (root.left==null && root.right==null) {
            res.add(sb.toString());
            sb.delete(sb.length()-len, sb.length());
            return;
        }
        sb.append("->");
        if (root.left!=null) {
            helper(root.left, sb, res);
        }
        if (root.right!=null) {
            helper(root.right, sb, res);
        }
        sb.delete(sb.length()-2-len, sb.length());
    }
}