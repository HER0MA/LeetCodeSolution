// t:2^n s:2^n
class Solution {
    public boolean canWin(String s) {
        return helper(s, new HashMap<String, Boolean>());
    }
    private boolean helper(String s, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        for (int i=0; i+1<s.length(); i++) {
            if (s.charAt(i)=='+' && s.charAt(i+1)=='+') {
                String afterFlip = s.substring(0, i) + "--" + s.substring(i+2);
                if (!helper(afterFlip, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}