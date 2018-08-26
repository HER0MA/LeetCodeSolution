// t:m*nlogn s:n
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null || strs.length==0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String str = new String(charArray);
            if (map.containsKey(str)) {
                map.get(str).add(strs[i]);
            } else {
                List<String> currList = new ArrayList<>();
                currList.add(strs[i]);
                map.put(str, currList);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}