// t:n s:1
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int res = 0;
        int[] count = new int[128];
        int distinct = 0;
        for (int left=0, right=0; right<s.length(); right++) {
            if (count[s.charAt(right)]==0) {
                distinct ++;
            }
            count[s.charAt(right)] ++;
            while (distinct>2) {
                count[s.charAt(left)] --;
                if (count[s.charAt(left)]==0) {
                    distinct --;
                }
                left ++;
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}