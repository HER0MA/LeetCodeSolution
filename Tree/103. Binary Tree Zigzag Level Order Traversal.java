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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean order = true;
        while (queue.size()!=0) {
            List<Integer> layer = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode curr = queue.poll();
                if (order) {
                    layer.add(curr.val);
                } else {
                    layer.add(0, curr.val);
                }
                if (curr.left!=null) {
                    queue.offer(curr.left);
                }
                if (curr.right!=null) {
                    queue.offer(curr.right);
                }
            }
            res.add(layer);
            order = !order;
        }
        return res;
    }
}