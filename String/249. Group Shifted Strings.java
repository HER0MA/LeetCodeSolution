// t:m*n s:n
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            sb.setLength(0);
            for (int i=0; i<str.length(); i++) {
                char ch = (char) (str.charAt(i) - offset);
                if (ch<'a') ch += 26;
                sb.append(ch);
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
}