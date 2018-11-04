// t:n s:n
class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        char[] res = new char[map.size()];
        int left = 0;
        int right = smallestValue(map);
        for (int i=0; i<res.length; i++) {
            char minChar = 'z'+1;
            // find min char that have not been used in [left, right]
            for (int j=left; j<=right; j++) {
                if (map.containsKey(s.charAt(j)) && s.charAt(j)<minChar) {
                    minChar = s.charAt(j);
                    // update left for next iteration
                    left = j+1;
                }
            }
            res[i] = minChar;
            map.remove(minChar);
            // if s[right] is selected, update right
            if (s.charAt(right)==minChar) {
                right = smallestValue(map);
            }
        }
        return new String(res);
    }
    private int smallestValue(Map<Character, Integer> map) {
        int res = Integer.MAX_VALUE;
        for (int num : map.values()) {
            res = Math.min(res, num);
        }
        return res;
    }
}