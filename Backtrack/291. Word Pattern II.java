// ?t:2^n s:n
class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        return isMatch(str, 0, pattern, 0, new HashMap<>(), new HashSet<>());
    }
    
    public boolean isMatch(String str, int i, String pattern, int j, Map<Character, String> map, Set<String> set) {
        if (i==str.length() && j==pattern.length()) return true;
        if (i==str.length() || j==pattern.length()) return false;
        
        char c = pattern.charAt(j);
        if (map.containsKey(c)) {
            String s = map.get(c);
            if (!str.startsWith(s, i)) return false;
            return isMatch(str, i+s.length(), pattern, j+1, map, set);
        }
        
        for (int k=i; k<str.length(); k++) {
            String s = str.substring(i, k+1);
            if (set.contains(s)) continue;
            map.put(c, s);
            set.add(s);
            if (isMatch(str, i+s.length(), pattern, j+1, map, set)) return true;
            map.remove(c);
            set.remove(s);
        }
        
        return false;
    }
}