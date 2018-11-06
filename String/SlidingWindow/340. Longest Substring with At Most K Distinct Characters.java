// t:n s:1
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[128];
        int distinctCount = 0;
        int res = 0;
        for (int left=0, right=0; right<s.length(); right++) {
            if (count[s.charAt(right)] == 0) {
                distinctCount ++;
            }
            count[s.charAt(right)] ++;
            while (distinctCount > k) {
                count[s.charAt(left)] --;
                if (count[s.charAt(left)] == 0) {
                    distinctCount --;
                }
                left ++;
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}