// t:n s:1
// Sliding window, similar to 76
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length()<s1.length()) return false;
        int[] demand = new int[128];
        for (int i=0; i<s1.length(); i++) {
            demand[s1.charAt(i)] ++;
        }
        int demandCount = s1.length();
        for (int i=0; i<s1.length()-1; i++) {
            if (demand[s2.charAt(i)]>0) {
                demandCount --;
            }
            demand[s2.charAt(i)] --;
        }
        for (int left=0, right=s1.length()-1; right<s2.length(); left++, right++) {
            if (demand[s2.charAt(right)]>0) {
                demandCount --;
            }
            demand[s2.charAt(right)] --;
            if (demandCount==0) return true;
            demand[s2.charAt(left)] ++;
            if (demand[s2.charAt(left)]>0) {
                demandCount ++;
            }
        }
        return false;
    }
}