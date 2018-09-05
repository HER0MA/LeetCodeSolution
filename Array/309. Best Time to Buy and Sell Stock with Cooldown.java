// t:n s:n
class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<2) return 0;
        int[] hold = new int[prices.length];
        int[] unHold = new int[prices.length];
        hold[0] = -prices[0];
        hold[1] = Math.max(-prices[0], -prices[1]);
        unHold[0] = 0;
        unHold[1] = prices[1]-prices[0]>0 ? prices[1]-prices[0] : 0;
        for (int i=2; i<prices.length; i++) {
            hold[i] = Math.max(hold[i-1], unHold[i-2]-prices[i]);
            unHold[i] = Math.max(unHold[i-1], hold[i-1]+prices[i]);
        }
        return Math.max(hold[prices.length-1], unHold[prices.length-1]);
    }
}
// optimize, use two variables instead of array to store
class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=1) return 0;
        // int[] hold = new int[prices.length];
        // int[] unhold = new int[prices.length];
        int holdPrev = -prices[0];
        int hold = Math.max(-prices[1], -prices[0]);// hold[0] = -prices[0];
        // hold[1] = -prices[1];
        int unholdPrev = 0;// unhold[0] = 0;
        int unhold = Math.max(0, prices[1]-prices[0]);// unhold[1] = Math.max(0, prices[1]-prices[0]);
        for (int i=2; i<prices.length; i++) {
            holdPrev = hold;
            hold = Math.max(hold, unholdPrev-prices[i]);
            unholdPrev = unhold;
            unhold = Math.max(unhold, holdPrev+prices[i]);   
        }
        return unhold;
    }
}