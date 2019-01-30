// Dynamic Programming
// t:m*n s:n
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0) return 0;
        // height of current rectangle (upward)
        int[] height = new int[matrix[0].length];
        // left boundary of current rectangle (include)
        // -1 means there is no rectangle
        int[] left = new int[matrix[0].length];
        Arrays.fill(left, -1);
        // right boundary of current rectangle (include)
        // matrix[0].length means there is no rectangle
        int[] right = new int[matrix[0].length];
        Arrays.fill(right, matrix[0].length);
        int res = 0;
        for (int i=0; i<matrix.length; i++) {
            // update height and left
            int currLeft = 0;
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    height[j] ++;
                    // if there is a rectangle in previous line
                    // currnent rectangle shoule be "higher"
                    // so do not update it
                    left[j] = Math.max(currLeft, left[j]);
                } else {
                    height[j] = 0;
                    left[j] = -1;
                    currLeft = j+1;
                }
            }
            // update right, caculate res
            int currRight = matrix[0].length-1;
            for (int j=matrix[0].length-1; j>=0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(currRight, right[j]);
                    res = Math.max(res, (right[j]-left[j]+1)*height[j]);
                } else {
                    right[j] = matrix[0].length;
                    currRight = j-1;
                }
            }
        }
        return res;
    }
}
// Largest Rectangle in Histogram
// t:m*n s:n
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0) return 0;
        int[] heights = new int[matrix[0].length];
        int res = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j]=='1') {
                    heights[j] ++;
                } else {
                    heights[j] = 0;
                }
            }
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;
    }
    
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i=0; i<=heights.length; i++) {
            int currHeight = i==heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()]>currHeight) {
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, (i-left-1)*height);
            }
            stack.push(i);
        }
        return res;
    }
}