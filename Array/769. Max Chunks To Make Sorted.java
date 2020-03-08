// t:n s:1
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int currMax = -1;
        for (int i = 0; i < arr.length; i++) {
            currMax = Math.max(currMax, arr[i]);
            if (currMax == i) {
                count++;
                currMax = -1;
            }
        }
        return count;
    }
}