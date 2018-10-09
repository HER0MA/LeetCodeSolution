// t:n^2 s:1
class Solution {
    private String res;
    public String longestPalindrome(String s) {
        if (s==null || s.length()==0) return "";
        res = "";
        for (int i=0; i<s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return res;
    }
    private void helper(String s, int i, int j) {
        while (i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)) {
            i--;
            j++;
        }
        // left: i+1, right: j-1, so length is j-1-(i+1)+1 = j-i-1
        if (j-i-1 > res.length()) {
            res = s.substring(i+1, j);
        }
    }
}
// t:n^2 s:n^2
class Solution {
    public String longestPalindrome(String s) {
        if (s==null || s.length()==0) return "";
        boolean[][] state = new boolean[s.length()][s.length()];
        state[0][0] = true;
        String res = s.substring(0,1);
        int max = 1;
        for (int i=1; i<s.length(); i++) {
            state[i][i] = true;
            state[i-1][i] = s.charAt(i-1)==s.charAt(i);
            if (max==1 && state[i-1][i]) {
                res = s.substring(i-1, i+1);
                max = 2;
            }
        }
        for (int diff=2; diff<s.length(); diff++) {
            for (int i=0; i+diff<s.length(); i++) {
                int j = i + diff;
                state[i][j] = state[i+1][j-1] && s.charAt(i)==s.charAt(j);
                if (diff+1>max && state[i][j]) {
                    max = diff+1;
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }
}