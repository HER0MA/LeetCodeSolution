// t:n s:n
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cd :cpdomains) {
            int i = cd.indexOf(' ');
            int count = Integer.valueOf(cd.substring(0, i));
            String url = cd.substring(i + 1);
            map.put(url, map.getOrDefault(url, 0) + count);
            for (i = 0; i < url.length(); i++) {
                if (url.charAt(i) == '.') {
                    String domain = url.substring(i + 1);
                    map.put(domain, map.getOrDefault(domain, 0) + count);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] parts = domain.split(" ");
            int count = Integer.valueOf(parts[0]);
            String[] subs = parts[1].split("\\.");
            String str = subs[subs.length - 1];
            map.put(str, map.getOrDefault(str, 0) + count);
            for (int i = subs.length - 2; i >=0; i--) {
                str = subs[i] + "." + str;
                map.put(str, map.getOrDefault(str, 0) + count);
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}