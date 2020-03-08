// t:n s:1
class Solution {
    public int trap(int[] height) {
        if (height==null || height.length<3) return 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left<right) {
            // left and right point are not processed
            if (height[left]<height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                // Since we always choose smaller one to update,
                // when we caculate left side
                // there always be a height taller than leftMax on the right side (not included in rightMax)
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
// t:n s:n
class Solution {
    public int trap(int[] height) {
        if (height==null || height.length<3) return 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i=1; i<height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        rightMax[height.length-1] = height[height.length-1];
        for (int i=height.length-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        int res = 0;
        for (int i=0; i<height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }
}