// t:n s:n
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, i);
            }
        }
        int bounder = 0;
        int prevCount = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            bounder = Math.max(bounder, map.get(ch));
            if (bounder == i) {
                res.add(i + 1 - prevCount);
                prevCount = i + 1;
            }
        }
        return res;
    }
}