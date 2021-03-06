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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size()!=0) {
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode curr = queue.poll();
                layer.add(curr.val);
                if (curr.left!=null) {
                    queue.offer(curr.left);
                }
                if (curr.right!=null) {
                    queue.offer(curr.right);
                }
            }
            res.add(layer);
        }
        return res;
    }
}