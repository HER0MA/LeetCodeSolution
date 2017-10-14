/*
	state:
	buy[i] max profit if we buy before day i
	sell[i] max profit if we sell before day i

	function:
	buy[i] = max(buy[i-1], sell[i-2] - price[i-1])
	sell[i] = max(sell[i-1], sell[i-1]+prices[i-1])

	initial value:
	buy[0] = int.min // day-1
	buy[1] = -price[0]
	sell[0] = 0 // day-1
	sell[1] = 0 // day 0

*/

/*
    buy[i] = max(sell[i-2]-price,buy[i-1])
    sell[i] = max(buy[i-1]+price,sell[i-1])
    buy[0] = -unlimited
    buy[1] = -price[0]
    sell[0] = 0
    sell[1] = 0
*/
class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length<=1) return 0;
        int[] buy = new int[length+1];
        int[] sell = new int[length+1];
        buy[0] = -Integer.MAX_VALUE;
        buy[1] = -prices[0];
        for(int i=2; i<length+1; i++){
            buy[i] = Math.max(buy[i-1],sell[i-2]-prices[i-1]);
            sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i-1]);
        }
        return sell[length];
    }
}