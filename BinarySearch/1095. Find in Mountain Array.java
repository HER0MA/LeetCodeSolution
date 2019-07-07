/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 // t:logn s:1
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        // binary search, find peak
        int start = 0;
        int end = n - 1;
        int peak = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        peak = mountainArr.get(start) > mountainArr.get(end) ? start : end;
        // binary search in increasing array
        start = 0;
        end = peak;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (mountainArr.get(start) == target) return start;
        if (mountainArr.get(end) == target) return end;
        // binary search in decreasing array
        start = peak;
        end = n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (mountainArr.get(start) == target) return start;
        if (mountainArr.get(end) == target) return end;
        return -1;
    }
}