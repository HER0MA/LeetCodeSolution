// t:nlogn s:1
class Solution {
    public int hIndex(int[] citations) {
        if (citations==null || citations.length==0) return 0;
        Arrays.sort(citations);
        int count = 0;
        for (int i=citations.length-1; i>=0; i--) {
            if (citations[i]<++count) {
                return count-1;
            }
        }
        return count;
    }
}