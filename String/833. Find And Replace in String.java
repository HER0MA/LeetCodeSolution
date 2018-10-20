// t:n s:n
class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        // key: index, value: original position of the index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<indexes.length; i++) {
            if (S.startsWith(sources[i], indexes[i])) {
                map.put(indexes[i], i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (i<S.length()) {
            if (map.containsKey(i)) {
                sb.append(targets[map.get(i)]);
                i += sources[map.get(i)].length();
            } else {
                sb.append(S.charAt(i));
                i ++;
            }
        }
        return sb.toString();
    }
}
// t:nlogn s:n
class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, String[]> map = new TreeMap<>((a,b) -> b-a);
        for (int i=0; i<indexes.length; i++) {
            map.put(indexes[i], new String[]{sources[i], targets[i]});
        }
        for (int i : map.keySet()) {
            if (S.startsWith(map.get(i)[0], i)) {
                S = S.substring(0, i) + map.get(i)[1] + S.substring(i + map.get(i)[0].length());
            }
        }
        return S;
    }
}