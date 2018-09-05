// t:k*n s:k*n
/* buy[i][j] means max profile when buy the ith time (at most i-1 full transaction and one buy)
 * 
 *  buy[i][j] = max{  buy[i][j-1], sell[i-1][j-1]-prices[j] }
 * sell[i][j] = max{ sell[i][j-1],  buy[i]  [j-1]+prices[j] }
 * 
 * initial state
 * buy[0][j] makes no sence and will not be used
 * buy[i][0] = -prices[0]
 * 
 * sell[0][0] = 0
 * sell[i][0] = 0
 * sell[0][j] = 0
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices==null || prices.length<=1) return 0;
        if (k>prices.length/2) {
            int ans = 0;
            for (int i=1; i<prices.length; i++) {
                if (prices[i]>prices[i-1]) {
                    ans += prices[i]-prices[i-1];
                }
            }
            return ans;
        }
        int[][] sell = new int[k+1][prices.length];
        int[][] buy = new int[k+1][prices.length];
        for (int i=1; i<k+1; i++) {
            buy[i][0] = -prices[0];
            for (int j=1; j<prices.length; j++) {
                 buy[i][j] = Math.max(  buy[i][j-1], sell[i-1][j-1]-prices[j] );
                sell[i][j] = Math.max( sell[i][j-1],  buy[i][j-1]+prices[j] );
            }
        }
        return sell[k][prices.length-1];
    }
}
/*
 * always same i for buy
 * optimize ->
 *  buy   [j] = max{  buy   [j-1], sell[i-1][j-1]-prices[j] }
 * sell[i][j] = max{ sell[i][j-1],  buy     [j-1]+prices[j] }
 * j and j-1
 * optimize ->
 * do not need array to store buy, just one variable
 * sell[i][j] = max{ sell[i][j-1],  buy(old)     +prices[j] }
 *  buy (new) = max{  buy(old)   , sell[i-1][j-1]-prices[j] } 
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices==null || prices.length<=1) return 0;
        if (k>prices.length/2) {
            int ans = 0;
            for (int i=1; i<prices.length; i++) {
                if (prices[i]>prices[i-1]) {
                    ans += prices[i]-prices[i-1];
                }
            }
            return ans;
        }
        int[][] sell = new int[k+1][prices.length];
        for (int i=1; i<k+1; i++) {
            int buy = -prices[0];
            for (int j=1; j<prices.length; j++) {
                sell[i][j] = Math.max( sell[i][j-1],  buy+prices[j] );
                buy = Math.max(  buy, sell[i-1][j-1]-prices[j] );
            }
        }
        return sell[k][prices.length-1];
    }
}