// t:n s:1
class Solution {
    public int countLetters(String s) {
        int[] count = new int[26];
        int distinct = 0;
        int res = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (count[s.charAt(right) - 'a']++ == 0) {
                distinct++;
            }
            while (distinct > 1) {
                if (--count[s.charAt(left) - 'a'] == 0) {
                    distinct--;
                }
                left++;
            }
            int len = right - left + 1;
            res += len;
        }
        return res;
    }
}