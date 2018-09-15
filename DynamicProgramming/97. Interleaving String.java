// t:l1*l2 s:l1*l2
/**
 * state[i][j] means whether (first i+j char of s3) is formed by 
 * the interleaving of (first i char of s1) and (first j char of s2) 
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1+l2!=s3.length()) return false;
        boolean state[][] = new boolean[l1+1][l2+1];
        state[0][0] = true;
        for (int i=1; i<=l1; i++) {
            state[i][0] = state[i-1][0] && s3.charAt(i-1)==s1.charAt(i-1);
        }
        for (int j=1; j<=l2; j++) {
            state[0][j] = state[0][j-1] && s3.charAt(j-1)==s2.charAt(j-1);
        }
        for (int i=1; i<=l1; i++) {
            for (int j=1; j<=l2; j++) {
                state[i][j] = state[i-1][j] && s3.charAt(i+j-1)==s1.charAt(i-1) 
                            || state[i][j-1] && s3.charAt(i+j-1)==s2.charAt(j-1);
            }
        }
        return state[l1][l2];
    }
}