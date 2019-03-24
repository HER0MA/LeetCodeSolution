// t:n s:n
public class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        reverse(str, 0, str.length - 1);
        int i = 0;
        int j = 0;
        while (i < str.length) {
            while (i < j || i < str.length && str[i] == ' ') i++;
            while (j < i || j < str.length && str[j] != ' ') j++;
            reverse(str, i, j - 1);
        }
        int slow = 0;
        int fast = 0;
        while (fast < str.length && str[fast] == ' ') fast++;
        while (fast < str.length) {
            while (fast < str.length && str[fast] != ' ') str[slow++] = str[fast++];
            while (fast < str.length && str[fast] == ' ') fast++;
            if (fast < str.length) str[slow++] = ' ';
        }
        return new String(str, 0, slow);
    }
    
    private void reverse(char[] str, int i, int j) {
        while (i < j) {
            char temp = str[i];
            str[i++] = str[j];
            str[j--] = temp;
        }
    }
}
// t:n s:n
public class Solution {
    public String reverseWords(String s) {
        if (s==null || s.length()==0) return s;
        String[] strs = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i=strs.length-1; i>=0; i--) {
            sb.append(strs[i]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }
}