// t:n^2 s:1
class Solution {
    public int countSubstrings(String s) {
        if (s==null || s.length()==0) return 0;
        int res = 0;
        for (int i=0; i<s.length(); i++) {
            res += helper(s, i, i);
            res += helper(s, i, i+1);
        }
        return res;
    }
    private int helper(String s, int i, int j) {
        int res = 0;
        while (i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)) {
            i--;
            j++;
            res ++;
        }
        return res;
    }
}