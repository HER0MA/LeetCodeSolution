// t:sqrt(N) s:1
// isochromatic sequence
class Solution {
    public int consecutiveNumbersSum(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            int a = 2 * N + i - i * i;
            if (a <= 0) break;
            if (a % (2 * i) != 0) continue;
            res++;
        }
        return res;
    }
}