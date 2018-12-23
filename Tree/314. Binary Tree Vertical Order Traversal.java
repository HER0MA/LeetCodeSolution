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
    private int min;
    private int max;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        min = 0;
        max = 0;
        // DFS to get range O(n)
        getRange(root, 0);
        for (int i=min; i<=max; i++) {
            res.add(new ArrayList<>());
        }
        // BFS O(n)
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> idxQueue = new LinkedList<>();
        nodeQueue.offer(root);
        idxQueue.offer(-min);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int idx = idxQueue.poll();
            res.get(idx).add(node.val);
            if (node.left != null) {
                nodeQueue.offer(node.left);
                idxQueue.offer(idx-1);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                idxQueue.offer(idx+1);
            }
        }
        return res;
    }
    
    private void getRange(TreeNode root, int idx) {
        if (root == null) return;
        min = Math.min(min, idx);
        max = Math.max(max, idx);
        getRange(root.left, idx-1);
        getRange(root.right, idx+1);
    }
}