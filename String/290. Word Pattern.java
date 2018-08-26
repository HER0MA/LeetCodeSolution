// t:n s:n
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length!=pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = strs[i];
            if (map.containsKey(c)) {
                if (!s.equals(map.get(c))) {
                    return false;
                }
            } else {
                if (map.containsValue(s)) {
                    return false;
                }
                map.put(c, s);
            }
        }
        return true;
    }
}