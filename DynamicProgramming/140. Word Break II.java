// t:n^3 s:n^3
// dfs
class Solution {
    private Map<String, List<String>> map;
    public List<String> wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        return helper(s, wordDict);
    }
    private List<String> helper(String s, List<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> curr = new ArrayList<>();
        for (int i=1; i<=s.length(); i++) {
            if (wordDict.contains(s.substring(0, i))) {
                // s in wordDict
                if (i==s.length()) {
                    curr.add(s);
                    break;
                }
                List<String> postfix = helper(s.substring(i), wordDict);
                if (postfix.size()!=0) {
                    for (String str : postfix) {
                        curr.add(s.substring(0, i)+' '+str);
                    }
                }
            }
        }
        map.put(s, curr);
        return curr;
    }
}
// Time Limit Exceeded
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        helper(s, wordDict, new ArrayList<String>(), res);
        return res;
    }
    private void helper(String s, List<String> wordDict, List<String> curr, List<String> res) {
        if (s.equals("")) {
            res.add(generateString(curr));
            return;
        }
        for (int i=1; i<=s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordDict.contains(prefix)) {
                curr.add(prefix);
                helper(s.substring(i), wordDict, curr, res);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    private String generateString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append(' ');
        }
        return sb.toString().trim();
    }
}