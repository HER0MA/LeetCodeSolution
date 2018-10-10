// t:n^2 s:n^2
// state[i][j] means longestPalindromeSubseq in substring from i to j(included)
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s==null || s.length()==0) return 0;
        int[][] state = new int[s.length()][s.length()];
        for (int i=0; i<s.length(); i++) {
            state[i][i] = 1;
        }
        for (int diff=1; diff<s.length(); diff++) {
            for (int i=0; i+diff<s.length(); i++) {
                int j = i+diff;
                if (s.charAt(i)==s.charAt(j)) {
                    // correct for diff==1
                    state[i][j] = state[i+1][j-1] + 2;
                } else {
                    state[i][j] = Math.max(state[i+1][j], state[i][j-1]);
                }
            }
        }
        return state[0][s.length()-1];
    }
}