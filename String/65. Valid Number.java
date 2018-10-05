// t:n s:1
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean num = false;
        boolean point = false;
        boolean e = false;
        boolean numAfterE = true;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c>='0' && c<='9') {
                num = true;
                numAfterE = true;
            } else if (c=='.') {
                if (point || e) {
                    return false;
                }
                point = true;
            } else if (c=='e') {
                if (e || !num) {
                    return false;
                }
                e = true;
                numAfterE = false;
            } else if (c=='+' || c=='-') {
                // !(i==0 || s.charAt(i-1)=='e') De Morgan's law
                if (i!=0 && s.charAt(i-1)!='e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return num && numAfterE;
    }
}