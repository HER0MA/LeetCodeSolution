// t:n s:1
class Solution {
    public String minWindow(String s, String t) {
        // demand['a'] = n means in s.substring(start, end+1):
        // n>0: we need n extra 'a's to satisfy t
        // n<0: we do not need more 'a', and there are |n| unnecessary 'a's
        int[] demand = new int[128];
        for (char c : t.toCharArray()) {
            demand[c]++;
        }
        // tDemand means number of chars needed to satisfy t
        int tDemand = t.length();
        int resIndex = 0;
        int len = Integer.MAX_VALUE;
        for (int end=0, start=0; end<s.length(); end++) {
            // add char at end to substring
            if (demand[s.charAt(end)]>0) {
                tDemand --;
            }
            demand[s.charAt(end)]--;
            // t is satisfied
            while (tDemand==0) {
                // update result
                if (end-start+1<len) {
                    len = end-start+1;
                    resIndex = start;
                }
                // remove char at start and move forward start 
                demand[s.charAt(start)]++;
                // there are new demands
                if (demand[s.charAt(start)]>0) {
                    tDemand ++;
                }
                start++;
            }
        }
        return len==Integer.MAX_VALUE ? "" : s.substring(resIndex, resIndex+len);
    }
}