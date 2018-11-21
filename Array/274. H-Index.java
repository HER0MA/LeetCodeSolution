// t:nlogn s:1
// based on count
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        // check if there are (count) numbers >= (count)
        // each iteration, count increase, smallest decrease
        for (int count=1; count<=citations.length; count++) {
            // if smallest number less than count
            // current count can not be satisfied, return previous one
            if (count > citations[citations.length-count]) return count-1;
        }
        // if smallest number is always >= count, all elements satisfy
        return citations.length;
    }
}
// t:n s:n
// based on smallest
class Solution {
    public int hIndex(int[] citations) {
        int[] counts = new int[citations.length+1];
        for (int citation : citations) {
            if (citation>citations.length) {
                counts[citations.length] ++;
            } else {
                counts[citation] ++;
            }
        }
        int count = 0;
        for (int smallest=counts.length-1; smallest>=0; smallest--) {
            count += counts[smallest];
            // return smallest when smallest is satisfied for first time
            if (smallest<=count) return smallest;
        }
        // if smallest is never satisfied, return 0
        return 0;
    }
}