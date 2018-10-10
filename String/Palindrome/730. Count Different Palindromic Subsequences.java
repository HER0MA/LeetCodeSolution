// t:n^3 s:n^2
class Solution {
    private static int MOD = 1000000007;
    public int countPalindromicSubsequences(String S) {
        int[][] state = new int[S.length()][S.length()];
        char[] str = S.toCharArray();
        state[0][0] = 1;
        for (int i=1; i<state.length; i++) {
            state[i][i] = 1;
            state[i-1][i] = 2;
        }
        for (int diff=2; diff<state.length; diff++) {
            for (int i=0; i+diff<state.length; i++) {
                int j = i+diff;
                if (str[i]==str[j]) {
                    int low = i+1;
                    int high = j-1;
                    while (low<=high && str[low]!=str[i]) low++;
                    while (low<=high && str[high]!=str[j]) high--;
                    if (low>high) {
                        state[i][j] = 2*state[i+1][j-1] + 2;
                        /* e.g. bacb
                         * PldSubSeq(bacb) = {PldSubSeq(ac)} + {"b"+PldSubSeq(ac)+"b"} + {"bb"} + {"b"}
                         *  ac   ->    a       c
                         * bacb  ->   bab     bcb     bb      b
                         *        +    a       c
                         */
                    } else if (low==high) {
                        state[i][j] = 2*state[i+1][j-1] + 1;
                        /* e.g. babcb
                         * PldSubSeq(babcb) = {PldSubSeq(abc)} + {"b"+PldSubSeq(abc)+"b"} + {"bb"}
                         * {"b"} is included in PldSubSeq(abc)
                         *  abc    ->    a       c       b
                         * babcb   ->   bab     bcb     bbb      bb    (b)
                         *          +    a       c       b
                         */
                    } else {
                        state[i][j] = 2*state[i+1][j-1] - state[low+1][high-1];
                        /* e.g. bcbabdb
                         * PldSubSeq(bcbabdb) = {PldSubSeq(cbabd)} + {"b"+PldSubSeq(cbabd)+"b"} - {PldSubSeq(a)}
                         * {"bb"} and {"b"} are included in PldSubSeq(bacb)
                         * do twice "b"+a+"b", so minus {PldSubSeq(a)}
                         *    a     ->    a       
                         *   bab    ->    a       bab      bb      b
                         *  cbabd   ->    a       bab      bb      b        c       d
                         * bcbabdb  ->   bab     bbabb    bbbb    bbb      bcb     bdb     (bb)   (b)
                         *           +    a      (bab)     bb      b        c       d
                         */
                    }
                } else {
                    state[i][j] = state[i+1][j] + state[i][j-1] - state[i+1][j-1];
                }
                state[i][j] = state[i][j]<0 ? state[i][j]+MOD : state[i][j]%MOD;
                // (a-b)%M = (a%M-b%M)+M when a%M-b%M<0
            }
        }
        return state[0][state.length-1];
    }
}