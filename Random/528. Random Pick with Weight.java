class Solution {
    private Random rand;
    private int[] weightAcc;
    private int weightSum;

    public Solution(int[] w) {
        rand = new Random();
        weightAcc = new int[w.length];
        weightAcc[0] = w[0];
        weightSum = w[0];
        for (int i=1; i<w.length; i++) {
            weightAcc[i] = weightAcc[i-1] + w[i];
            weightSum+=w[i];
        }
    }

    public int pickIndex() {
        int target = rand.nextInt(weightSum);
        /*
         * binary search in weightAcc (wA) to find index
         * wA[mid]==target          -> return mid+1
         * wA[start]<target<wA[end] -> return end
         */
        if (target<weightAcc[0]) return 0;
        if (target==weightAcc[0]) return 1;
        int start = 0;
        int end = weightAcc.length-1;
        while (start+1<end) {
            int mid = start + (end-start)/2;
            if (weightAcc[mid]==target) {
                return mid+1;
            } else if (target>weightAcc[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */