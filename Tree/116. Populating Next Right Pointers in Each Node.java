/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
// Iteration
// t:n s:1
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root==null) return;
        TreeLinkNode head = root;
        while (head!=null) {
            TreeLinkNode curr = head;
            while (curr!=null) {
                if (curr.left!=null) {
                    curr.left.next = curr.right;
                }
                if (curr.next!=null && curr.right!=null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            head = head.left;
        }
    }
}
// Recursion
// t:n s:logn
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root==null) return;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next!=null && root.right!=null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
// BFS
// t:n s:n
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root==null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode prev = queue.poll();
            if (prev.left!=null) queue.offer(prev.left);
            if (prev.right!=null) queue.offer(prev.right);
            for (int i=1; i<size; i++) {
                TreeLinkNode curr = queue.poll();
                prev.next = curr;
                prev = curr;
                if (curr.left!=null) queue.offer(curr.left);
                if (curr.right!=null) queue.offer(curr.right);
            }
        }
    }
}