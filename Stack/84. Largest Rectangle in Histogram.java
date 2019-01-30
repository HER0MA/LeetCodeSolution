// t:n s:n
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        // stack stores in ascending order
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<=heights.length; i++) {
        	// add 0 height to end to process remaining heights in stack
            int currHeight = i==heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()]>currHeight) {
            	// if stack contains larger height
            	// pop and caculate area
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                // right boundary is i
                // left and right are excluded
                res = Math.max(res, (i-left-1)*height);
            }
            stack.push(i);
        }
        return res;
    }
}