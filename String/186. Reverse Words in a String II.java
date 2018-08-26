// t:n s:1
public class Solution {
    /**
     * @param str: a string
     * @return: return a string
     */
    public char[] reverseWords(char[] str) {
        // write your code here
        reverse(str, 0, str.length-1);
        int right = 0;
        while (right < str.length) {
            int left = right;
            while (right<str.length && str[right]!=' ') {
                right ++;
            }
            reverse(str, left, right-1);
            right ++;
        }
        return str;
    }
    private void reverse(char[] str, int left, int right) {
        while (left < right) {
            char temp = str[left];
            str[left++] = str[right];
            str[right--] = temp;
        }
    }
}