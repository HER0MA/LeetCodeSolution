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
    public TreeNode recoverFromPreorder(String s) {
        int idx = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        while (idx < s.length()) {
            int level = 0;
            while (idx < s.length() && s.charAt(idx) == '-') {
                level++;
                idx++;
            }
            int val = 0;
            while (idx < s.length() && s.charAt(idx) != '-') {
                val = val * 10 + s.charAt(idx) - '0';
                idx++;
            }
            TreeNode node = new TreeNode(val);
            while (deque.size() > level) deque.pollLast();
            if (!deque.isEmpty()) {
                TreeNode parent = deque.peekLast();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
            deque.offerLast(node);
        }
        return deque.peekFirst();
    }
}