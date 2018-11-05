// t:n^2 s:1
// [0, end] is palindrome, find max end
class Solution {
    public String shortestPalindrome(String s) {
        int end = s.length()-1;
        int i = 0;
        int j = end;
        while (i<j) {
            if (s.charAt(i)==s.charAt(j)) {
                i ++;
                j --;
            } else { // [0, end] is not a palindrome
                end --;
                i = 0;
                j = end;
            }
        }
        // reverse [end+1, s.length()] and add before s
        return new StringBuilder(s.substring(end+1)).reverse().toString() + s;
    }
}