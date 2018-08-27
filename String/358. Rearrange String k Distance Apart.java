// t:n s:n
class Solution {
    public String rearrangeString(String s, int k) {
        if (s==null || s.length()==0) return "";
        int[] count = new int[26];
        // A letter should be put at least in nextPos[Letter-'a']
        int[] nextPos = new int[26];
        for (int i=0; i<s.length(); i++) {
            count[s.charAt(i)-'a'] ++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            int currChar = findChar(i, count, nextPos);
            if (currChar == -1) {
                return "";
            }
            sb.append((char)(currChar + 'a'));
            count[currChar]--;
            nextPos[currChar] += k;
        }
        return sb.toString();
    }
    // find the char that should be put in this position(index)
    private int findChar(int index, int[] count, int[] nextPos) {
        int max = 0;
        int res = -1;
        for (int i=0; i<26; i++) {
            // most letter first
            // nextPos confines k distance
            // if no eligible letter return -1
            if (count[i]>max && nextPos[i]<=index) {
                max = count[i];
                res = i;
            }
        }
        return res;
    }
}