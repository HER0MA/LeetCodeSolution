// t:m^2*nlogn s:n
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length==0 || matrix[0].length==0) return 0;
        int res = Integer.MIN_VALUE;
        for (int left=0; left<matrix[0].length; left++) {
            int[] sums = new int[matrix.length];
            for (int right=left; right<matrix[0].length; right++) {
                for (int line=0; line<matrix.length; line++) {
                    // sum[line] is sum of current line from left to right
                    sums[line] += matrix[line][right];
                }
                res = Math.max(res, maxSumSubArray(sums, k));
            }
        }
        return res;
    }
    // t:nlogn s:n
    private int maxSumSubArray(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int currSum = 0;
        for (int num : nums) {
            currSum += num;
            // prevMinSum >= currSum - k
            // currSum - prevMinSum <= k
            Integer prevMinSum = set.ceiling(currSum-k);
            if (prevMinSum != null) {
                res = Math.max(res, currSum-prevMinSum);
            }
            set.add(currSum);
        }
        return res;
    }
}