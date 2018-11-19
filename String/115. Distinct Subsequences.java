// Dynamic Programming
// t:m*n s:m*n
class Solution {
    public int numDistinct(String s, String t) {
        int[][] state = new int[s.length()+1][t.length()+1];
        for (int i=0; i<state.length; i++) {
            state[i][0] = 1;
        }
        for (int i=1; i<state.length; i++) {
            for (int j=1; j<state[0].length; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)) {
                    state[i][j] = state[i-1][j-1] + state[i-1][j];
                } else {
                    state[i][j] =state[i-1][j];
                }
            }
        }
        return state[s.length()][t.length()];
    }
}
// BackTrack Solution, Time Limit Exceed
// t: s:n
class Solution {
    private int res;
    
    public int numDistinct(String s, String t) {
        res = 0;
        helper(0, 0, s, t);
        return res;
    }
    
    private void helper(int sIdx, int tIdx, String s, String t) {
        if (tIdx==t.length()) {
            res++;
            return;
        }
        for (int i=sIdx; i<s.length(); i++) {
            if (s.charAt(i)==t.charAt(tIdx)) {
                helper(i+1, tIdx+1, s, t);
            }
        }
    }
}