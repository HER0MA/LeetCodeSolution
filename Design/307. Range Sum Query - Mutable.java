// Binary Indexed Tree Solution
// s:n
class NumArray {
    private int[] tree;
    //t:n
    public NumArray(int[] nums) {
        tree = new int[nums.length+1];
        for (int i=1; i<tree.length; i++) {
            tree[i] += nums[i-1];
            int j = i + (i&-i); // & has low priority
            if (j<tree.length) {
                tree[j] += tree[i];
            }
        }
    }
    // t:logn
    public void update(int i, int val) {
        int delta = val - sumRange(i,i);
        i ++;
        while (i<tree.length) {
            tree[i] += delta;
            i += i&-i;
        }
    }
    // t:logn
    public int sumRange(int i, int j) {
        return sum(j) - sum(i-1);
    }
    // t:logn
    private int sum(int i) {
        i ++;
        int res = 0;
        while (i>0) {
            res += tree[i];
            i -= i&-i;
        }
        return res;
    }
}
// Segment Tree Solution
// s:n
class NumArray {
    class SegmentTreeNode {
        int start;
        int end;
        SegmentTreeNode left;
        SegmentTreeNode right;
        int sum;
        
        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
    
    private SegmentTreeNode root;
    // t:n
    public NumArray(int[] nums) {
        if (nums==null || nums.length==0) {
            root = null;
            return;
        }
        root = buildTree(0, nums.length-1, nums);
    }
    
    private SegmentTreeNode buildTree(int start, int end, int[] nums) {
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start==end) {
            root.sum = nums[start];
            return root;
        }
        int mid = start + (end-start)/2;
        root.left = buildTree(start, mid, nums);
        root.right = buildTree(mid+1, end, nums);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    // t:logn
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    private void update(SegmentTreeNode root, int idx, int val) {
        if (root.start==root.end) {
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end-root.start)/2;
        if (idx<=mid) {
            update(root.left, idx, val);
        } else {
            update(root.right, idx, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }
    // t:logn
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    private int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.start==start && root.end==end) return root.sum;
        int mid = root.start + (root.end-root.start)/2;
        if (end<=mid) return sumRange(root.left, start, end);
        if (start>=mid+1) return sumRange(root.right, start, end);
        return sumRange(root.left, start, mid) + sumRange(root.right, mid+1, end);
    }
}