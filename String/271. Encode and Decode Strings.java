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

// lower efficient, but can handler more complex situation
// "//" for '/', "/e" for split, can add more escape characters
public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            for (int i=0; i<str.length(); i++) {
                if (str.charAt(i) == '/') {
                    sb.append("//");
                } else {
                    sb.append(str.charAt(i));
                }
            }
            sb.append("/e");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i=0;
        StringBuilder sb = new StringBuilder();
        while (i<s.length()) {
            if (s.charAt(i) == '/') {
                if (s.charAt(i+1) == 'e') {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append('/');
                }
                i += 2;
            } else {
                sb.append(s.charAt(i));
                i ++;
            }
        }
        return res;
    }
}