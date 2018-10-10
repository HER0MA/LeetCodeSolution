/** 
 * state[t][g][p] means number of schemes to get at least p profit within fisrt k tasks and g group members.
 * transition:  state[t][g][p] = state[t-1][g][p] + state[t-1][g-group[t]][p-profit[t]]
 * optimize:    state   [g][p] = state     [g][p] + state     [g-group[t]][p-profit[t]]
 */
// t: t*g*p s:g*p
class Solution {
    private static int MOD = (int) 1e9+7;
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][] state = new int[G+1][P+1];
        state[0][0] = 1;
        // smaller g,p should be updated later
        for (int t=1; t<=profit.length; t++) {
            int currGroup = group[t-1];
            int currProfit = profit[t-1];
            for (int g=G; g>=currGroup; g--) {
                for (int p=P; p>=0; p--) {
                    state[g][p] += state[g-currGroup][Math.max(p-currProfit, 0)];
                    state[g][p] %= MOD;
                }
            }
        }
        int sum = 0;
        for (int i=0; i<=G; i++) {
            sum += state[i][P];
            sum %= MOD;
        }
        return sum;
    }
}
// t: t*g*p s:t*g*p
class Solution {
    private static int MOD = (int) 1e9+7;
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][][] state = new int[profit.length+1][G+1][P+1];
        state[0][0][0] = 1;
        // state[0][g][p] = 0;
        for (int t=1; t<=profit.length; t++) {
            for (int g=0; g<=G; g++) {
                for (int p=0; p<=P; p++) {
                    state[t][g][p] = state[t-1][g][p];
                    int currGroup = group[t-1];
                    int currProfit = profit[t-1];
                    if (g>=currGroup) {
                        // currProfit >= p mean we can get 0 profit within first k-1 tasks
                        state[t][g][p] += state[t-1][g-currGroup][Math.max(p-currProfit, 0)];
                        state[t][g][p] %= MOD;
                    }
                }
            }
        }
        int sum = 0;
        for (int i=0; i<=G; i++) {
            sum += state[profit.length][i][P];
            sum %= MOD;
        }
        return sum;
    }
}