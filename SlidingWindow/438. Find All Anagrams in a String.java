// t:n s:n
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        int[] demand = new int[26];
        int totalDemand = p.length();
        for (int i=0; i<p.length(); i++) {
            demand[p.charAt(i)-'a'] ++;
        }
        for (int i=0; i<p.length()-1; i++) {
            if (demand[s.charAt(i)-'a']-- >0) {
                totalDemand --;
            }
        }
        for (int left=0, right=p.length()-1; right<s.length(); left++, right++) {
            if (demand[s.charAt(right)-'a']-- > 0) {
                if (--totalDemand==0) res.add(left);
            }
            if (++demand[s.charAt(left)-'a'] > 0) {
                totalDemand ++;
            }
        }
        return res;
    }
}