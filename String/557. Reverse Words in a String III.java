// t:n s:1
class Solution {
    public String reverseWords(String s) {
        int i = 0;
        int j = 0;
        char[] str = s.toCharArray();
        while (i < str.length) {
            while (i < str.length && str[i] == ' ') i++;
            j = i;
            while (j < str.length && str[j] != ' ') j++;
            reverse(str, i, j - 1);
            i = j;
        }
        return new String(str);
    }
    
    private void reverse(char[] str, int i, int j) {
        while (i < j) {
            char temp = str[i];
            str[i++] = str[j];
            str[j--] = temp;
        }
    }
}