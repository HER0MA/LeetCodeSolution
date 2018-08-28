// t:n s:1
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = words.length;
        int i1 = -1;
        int i2 = -1;
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            } else if (words[i].equals(word2)) {
                i2 = i;
            }
            if (i1!=-1 && i2!=-1) {
                res = Math.min(res, Math.abs(i1-i2));
            }
        }
        return res;
    }
}