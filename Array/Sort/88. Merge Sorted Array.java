// t:n s:1
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int resIdx = m+n-1;
        int i1 = m-1;
        int i2 = n-1;
        while (i1>=0 && i2>=0) {
            if (nums1[i1]>nums2[i2]) {
                nums1[resIdx--] = nums1[i1--];
            } else {
                nums1[resIdx--] = nums2[i2--];
            }
        }
        while (i2>=0) {
            nums1[resIdx--] = nums2[i2--];
        }
    }
}