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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr==null) {
                sb.append("n ");
            } else {
                sb.append(curr.val+" ");
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i=1; i<nodes.length; i++) {
            TreeNode curr = queue.poll();
            if (!nodes[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.valueOf(nodes[i]));
                curr.left = left;
                queue.offer(left);
            }
            i++;
            if (!nodes[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.valueOf(nodes[i]));
                curr.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));