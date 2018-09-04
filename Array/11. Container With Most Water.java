// t:n s:1
class Solution {
    public int maxArea(int[] height) {
        if (height==null || height.length<2) return 0;
        int res = 0;
        int left = 0;
        int right = height.length-1;
        while (right > left) {
            int h = Math.min(height[left], height[right]);
            res = Math.max(res, h*(right-left));
            if (height[left]<height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}