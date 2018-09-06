// t:log(m+n) s:1
/* 
 * Turn finding median into finding the kth number 
 * number before s1 and s2 are deleted numbers
 * so if (s1>=nums1.length) we just return the kth number in B, same with B
 * choose k/2 th number of each array to compare
 * and delete first k/2 elements of the smaller array
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len%2==1) { // odd
            return findKth(nums1, 0, nums2, 0, len/2+1);
        } else { // even
            return (findKth(nums1, 0, nums2, 0, len/2+1)+findKth(nums1, 0, nums2, 0, len/2))/2;
        }
    }
    private double findKth(int[] nums1, int s1, int[] nums2, int s2, int k) {
        if (s1>=nums1.length) return nums2[s2+k-1]; // all elements in nums1 are deleted
        if (s2>=nums2.length) return nums1[s1+k-1]; // all elements in nums2 are deleted
        if (k==1) return Math.min(nums1[s1], nums2[s2]);
        /*
         * if one array does not have enough elements, just delete k/2 elements in the other, 
         * because these elements can not be larger than the kth elements
        */
        int key1 = s1+k/2-1<nums1.length ? nums1[s1+k/2-1] : Integer.MAX_VALUE;
        int key2 = s2+k/2-1<nums2.length ? nums2[s2+k/2-1] : Integer.MAX_VALUE;
        if (key1<key2) {
            // delete k/2 elements in nums1
            return findKth(nums1, s1+k/2, nums2, s2, k-k/2);
        } else {
            // delete k/2 elements in nums2
            return findKth(nums1, s1, nums2, s2+k/2, k-k/2);
        }
    }
}