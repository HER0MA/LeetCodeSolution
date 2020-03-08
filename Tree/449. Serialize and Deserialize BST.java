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
    // Inorder traversal
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sb.append(node.val + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] vals = data.split(" ");
        Queue<Integer> queue = new LinkedList<>();
        for (String val : vals) {
            queue.offer(Integer.valueOf(val));
        }
        return generateNode(queue);
    }
    
    private TreeNode generateNode(Queue<Integer> queue) {
        if (queue.isEmpty()) return null;
        TreeNode root = new TreeNode(queue.poll());
        Queue<Integer> smallQueue = new LinkedList<>();
        while (!queue.isEmpty() && root.val > queue.peek()) {
            smallQueue.offer(queue.poll());
        }
        root.left = generateNode(smallQueue);
        root.right = generateNode(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));