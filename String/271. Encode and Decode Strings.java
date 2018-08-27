public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs==null || strs.size()==0) return "";
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append(":");
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        if ("".equals(s)) return res;
        int left = 0, right = 0;
        while (left<s.length()) {
            while (s.charAt(right)!=':') {
                right++;
            }
            int len = Integer.parseInt(s.substring(left, right));
            res.add(s.substring(right+1, right+1+len));
            left = right + 1 + len;
            right = left;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));