// t:n^2 s:n
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s==null || s.length()==0 || words==null || words.length==0) return res;
        // hashMap save word number
        HashMap<String, Integer> map = new HashMap<>();
        int n = words.length;
        int len = words[0].length();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        // check each position
        for (int i=0; i<=s.length()-n*len; i++) {
            int wordCount = 0;
            int startIdx = i;
            HashMap<String, Integer> mapCopy = new HashMap<>(map);
            while (wordCount < n) {
                String str = s.substring(startIdx, startIdx+len);
                if (mapCopy.getOrDefault(str, 0)<1) break;
                mapCopy.put(str, mapCopy.get(str)-1);
                wordCount ++;
                startIdx += len;
            }
            if (wordCount==n) res.add(i);
        }
        return res;
    }
}