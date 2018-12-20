/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
// t:n s:1
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root==null) return;
        TreeLinkNode head = root;
        TreeLinkNode prevHead = null;
        while (head!=prevHead) {
            prevHead = head;
            TreeLinkNode curr = head;
            TreeLinkNode prev = null;
            while (curr!=null) {
                if (curr.left!=null) {
                    if (prev!=null) {
                        prev.next = curr.left;
                    } else {
                        head = curr.left;
                    }
                    prev = curr.left;
                }
                if (curr.right!=null) {
                    if (prev!=null) {
                        prev.next = curr.right;
                    } else {
                        head = curr.right;
                    }
                    prev = curr.right;
                }
                curr = curr.next;
            }
        }
    }
}
// easier to understand
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root==null) return;
        TreeLinkNode head = root;
        while (head!=null) {
            TreeLinkNode curr = head;
            TreeLinkNode prev = null;
            while (curr!=null) {
                if (curr.left!=null) {
                    if (prev!=null) {
                        prev.next = curr.left;
                    }
                    prev = curr.left;
                }
                if (curr.right!=null) {
                    if (prev!=null) {
                        prev.next = curr.right;
                    }
                    prev = curr.right;
                }
                curr = curr.next;
            }
            head = nextLayerHead(head);
        }
    }
    
    private TreeLinkNode nextLayerHead(TreeLinkNode head) {
        while (head!=null && head.left==null && head.right==null) {
            head = head.next;
        }
        if (head==null) return null;
        if (head.left != null) return head.left;
        return head.right;
    } 
}