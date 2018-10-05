// t:n*k s:k
/**
 * min1 the index of minimum res
 * min2 the index of 2nd minimum res
 */
class Solution {
    public int minCostII(int[][] costs) {
        if (costs==null || costs.length==0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[] state = new int[k];
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i=0; i<k; i++) {
            state[i] = costs[0][i];
            if (state[i]<=min) {
                min2 = min;
                min = state[i];
            } else if (state[i]<min2) {
                min2 = state[i];
            }
        }
        for (int j=1; j<n; j++) {
            int minPrev = min;
            int min2Prev = min2;
            min = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
            for (int i=0; i<k; i++) {
                state[i] = state[i]==minPrev ? min2Prev : minPrev;
                state[i] += costs[j][i];
                if (state[i]<=min) {
                    min2 = min;
                    min = state[i];
                } else if (state[i]<min2) {
                    min2 = state[i];
                }
            }
        }
        return min;
    }
}

// t:n*k s:1
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;

        int min1 = -1, min2 = -1;
        for (int i = 0; i < n; i++) {
            int last1 = min1, last2 = min2;
            min1 = -1; min2 = -1;
            for (int j = 0; j < k; j++) {
                if (j != last1) {
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                } else {
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }

                if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }
        return costs[n - 1][min1];
    }
}

// t:n*k s:n*k
class Solution {
    public int minCostII(int[][] costs) {
        if (costs==null || costs.length==0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[][] res = new int[n][k];
        int min1 = -1, min2 = -1;
        for (int i=0; i<k; i++) {
            res[0][i] = costs[0][i];
            if (min1==-1 || res[0][i]<res[0][min1]) {
                min2 = min1;
                min1 = i;
            } else if (min2==-1 || res[0][i]<res[0][min2]) {
                min2 = i;
            }
        }
        for (int i=1; i<n; i++) {
            int min1P = min1, min2P = min2;
            min1 = -1; min2 = -1;
            for (int j=0; j<k; j++) {
                if (j!=min1P) {
                    res[i][j] = res[i-1][min1P] + costs[i][j];
                } else {
                    res[i][j] = res[i-1][min2P] + costs[i][j];
                }
                if (min1==-1 || res[i][j]<res[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2==-1 || res[i][j]<res[i][min2]) {
                    min2 = j;
                }
            }
        }
        return res[n-1][min1];
    }
}