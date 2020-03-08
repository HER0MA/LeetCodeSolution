// t:n s:n
class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet();
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if (map.containsKey(ch1) && map.get(ch1) != ch2) return false;
            map.put(ch1, ch2);
            set.add(ch2);
        }
        if (set.size() == 26) return str2.equals(str1);
        return true;
    }
}