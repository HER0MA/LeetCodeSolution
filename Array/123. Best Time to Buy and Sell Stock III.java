// t:n s:1
/* buy1[i] = max{buy1[i], -prices[i]}
 * sell1[i] = max{sell1[i-1], buy1[i-1]+prices[i]}
 * buy2[i] = max{buy2[i], sell1[i-1]-prices[i]}
 * sell2[i] = max{sell2[i-1], buy2[i-1]+prices[i]}
 * optimize to O(1) space complexity
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0) return 0;
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int i=0; i<prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1+prices[i]);
            buy2 = Math.max(buy2, sell1-prices[i]);
            sell2 = Math.max(sell2, buy2+prices[i]);
        }
        return sell2;
    }
}