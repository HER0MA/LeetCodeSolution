// t:n s:1
class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            char ch = res.charAt(0);
            for (int j = 0; j < res.length(); j++) {
                if (res.charAt(j) == ch) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(ch);
                    count = 1;
                    ch = res.charAt(j);
                }
            }
            sb.append(count);
            sb.append(ch);
            res = sb.toString();
        }
        return res;
    }
}