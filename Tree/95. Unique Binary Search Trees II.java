/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// t:n^2 s:n^2
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new ArrayList<>(); 
        return generateTreesInRange(1, n);
    }
    
    private List<TreeNode> generateTreesInRange(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        } else if (start > end) {
            res.add(null);
            return res;
        }
        for (int i=start; i<=end; i++) {
            List<TreeNode> leftTrees = generateTreesInRange(start, i-1);
            List<TreeNode> rightTrees = generateTreesInRange(i+1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}