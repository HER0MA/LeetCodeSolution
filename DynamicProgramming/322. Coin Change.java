// t:n*amount s:amount
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i=1; i<amount+1; i++) {
            for (int j=0; j<coins.length; j++) {
                // res[k]==Integer.MAX_VALUE -> amount k can not be changed
                if (i>=coins[j] && res[i-coins[j]]!=Integer.MAX_VALUE) {
                    res[i] = Math.min(res[i], res[i-coins[j]]+1);
                }
            }
        }
        return res[amount]==Integer.MAX_VALUE ? -1 : res[amount];
    }
}