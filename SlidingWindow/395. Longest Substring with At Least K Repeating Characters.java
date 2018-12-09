// s:n t:1
class Solution {
    public int longestSubstring(String s, int k) {
        if (s==null || s.length()==0) return 0;
        int res = 0;
        for (int i=1; i<=Math.min(26, s.length()); i++) {
            res = Math.max(res, helper(s, k, i));
        }
        return res;
    }
    
    private int helper(String s, int k, int distinctTarget) {
        int res = 0;
        int[] count = new int[128];
        int notLessThanK = 0;
        int distinct = 0;
        for (int left=0, right=0; right<s.length(); right++) {
            if (count[s.charAt(right)]==0) distinct ++;
            // can not write else if, for len(s)==1 both are true
            if (count[s.charAt(right)]==k-1) notLessThanK ++;
            count[s.charAt(right)] ++;
            while (distinct > distinctTarget) {
                count[s.charAt(left)] --;
                if (count[s.charAt(left)]==0) distinct --;
                if (count[s.charAt(left)]==k-1) notLessThanK --;
                left ++;
            }
            if (distinct==distinctTarget && notLessThanK==distinct) {
                res = Math.max(res, right-left+1);
            }
        }
        return res;
    }
}