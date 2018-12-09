// t:n s:n
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        if (k>=flowers.length) return -1;
        // days[i] = x means position i blooms at day x
        int[] days = new int[flowers.length+1];
        for (int i=0; i<flowers.length; i++) {
            days[flowers[i]] = i+1;
        }
        int left = 1;
        int right = left+k+1;
        // if all elements between left and right are larger than max{days[left], days[right]}
        // than (left, right) is a valid res
        int lastDay = Math.max(days[left], days[right]);
        int res = Integer.MAX_VALUE;
        for (int i=1; i<days.length; i++) {
            if (i==right) {
                res = Math.min(res, lastDay);
                continue;
            }
            // if days[i]<lastDay, move the sliding window
            if (days[i]<lastDay) {
                left = i;
                right = left+k+1;
                if (right>=days.length) break;
                lastDay = Math.max(days[left], days[right]);
            }
        }
        return res==Integer.MAX_VALUE ? -1 : res;
    }
}