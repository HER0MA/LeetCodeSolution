/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root==null) return ans;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();//important
        queue.add(root);
        int size = 0;
        LinkedList<Integer> temp = null;
        TreeNode curr = null;
        while(!queue.isEmpty()){
            size = queue.size();
            temp = new LinkedList<Integer>();
            for(int i=0; i<size; i++){
                curr = queue.poll();
                temp.add(curr.val);
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
            ans.add(0,temp);// important！
        }
        return ans;
    }
}