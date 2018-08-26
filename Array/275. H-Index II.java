// t:logn s:1
class Solution {
    public int hIndex(int[] citations) {
        if (citations==null || citations.length==0) return 0;
        int start = 0;
        int end = citations.length-1;
        while (start+1 < end) {
            int mid = start + (end - start)/2;
            if (citations[mid]==citations.length-mid) {
                return citations.length-mid;
            } else if (citations[mid]>citations.length-mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (citations[start]>=citations.length-start) {
            return citations.length-start;
        } else if (citations[end]>=citations.length-end) {
            return citations.length-end;
        }
        return 0;
    }
}