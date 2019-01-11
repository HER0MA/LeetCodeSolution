// t:2^n s:n^2
class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(0, 0, "", word, res);
        return res;
    }
    // count means number of abbreviated chars from last kept char
    public void helper(int idx, int count, String curr, String word, List<String> res) {
        if (idx == word.length()) {
            if (count > 0) curr += count;
            res.add(curr);
            return;
        }
        // abbreviate char at idx
        helper(idx+1, count+1, curr, word, res);
        // keep char at idx
        if (count>0) curr += count;
        curr += word.charAt(idx);
        helper(idx+1, 0,       curr, word, res);
    }
}

class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<>();
        list.add("");
        if (word.length()==0) return list;
        Map<String, List<String>> map = new HashMap<>();
        map.put("", list);
        return helper(word, map);
    }
    
    public List<String> helper(String word, Map<String, List<String>> map) {
        if (map.containsKey(word)) return map.get(word);
        Set<String> res = new HashSet<>();
        res.add(""+word.length());
        for (int i=0; i<word.length(); i++) {
            List<String> leftRes  = helper(word.substring(0, i), map);
            List<String> rightRes = helper(word.substring(i+1, word.length()), map);
            char ch = word.charAt(i);
            for (String left : leftRes) {
                for (String right : rightRes) {
                    res.add(left+ch+right);
                }
            }
        }
        List<String> list = new ArrayList<String>(res);
        map.put(word, list);
        return list;
    }
}