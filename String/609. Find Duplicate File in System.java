// t:n*len s:n*len
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] parts = path.split("\\s+");
            for (int i = 1; i < parts.length; i++) {
                int idx = parts[i].indexOf('(');
                String content = parts[i].substring(idx + 1, parts[i].length() - 1);
                if (!map.containsKey(content)) {
                    map.put(content, new HashSet<>());
                }
                map.get(content).add(parts[0] + "/" + parts[i].substring(0, idx));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            Set<String> set = entry.getValue();
            if (set.size() > 1) {
                res.add(new ArrayList(set));
            }
        }
        return res;
    }
}