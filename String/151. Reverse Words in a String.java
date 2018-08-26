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