// t:n s:n
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        int left = 0, right = 0;
        while (right<s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left ++;
            } else {
                set.add(s.charAt(right));
                res = Math.max(res, right-left+1);
                right ++;
            }
        }
        return res;
    }
}