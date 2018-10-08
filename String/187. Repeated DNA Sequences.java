// t:n s:n
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i=0; i<s.length()-9; i++) {
            String temp = s.substring(i, i+10);
            if (set.contains(temp)) {
                res.add(temp);
            } else {
                set.add(temp);
            }
        }
        return new ArrayList<>(res);
    }
}