// t:n s:1
class Solution {
    public boolean validPalindrome(String s) {
        return helper(0, s.length() - 1, false, s);
    }
    
    private boolean helper(int left, int right, boolean deleted, String s) {
        if (left >= right) return true;
        if (s.charAt(left) == s.charAt(right))
            return helper(left + 1, right - 1, deleted, s);
        if (deleted) return false;
        return helper(left + 1, right, true, s) || helper(left, right - 1, true, s);
    }
}