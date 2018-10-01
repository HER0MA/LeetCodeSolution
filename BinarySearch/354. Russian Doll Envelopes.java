// t:nlogn s:n
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes==null || envelopes.length==0) return 0;
        // sort envelopes on (1) width ascend and (2) height descend
        Arrays.sort(envelopes, (a,b) -> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        // Longest Increasing Sequence on height
        int[] array = new int[envelopes.length];
        int size = 0;
        for (int[] e : envelopes) {
            int pos = replacePos(e[1], size, array);
            array[pos] = e[1];
            if (pos==size) size++;
        }
        return size;
    }
    private int replacePos(int x, int size, int[] array) {
        if (size==0 || array[0]>=x) return 0;
        if (array[size-1]<x) return size;
        int start = 0;
        int end = size-1;
        while (start+1 < end) {
            int mid = start + (end-start)/2;
            if (array[mid]<x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }
}