// t:n s:1
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        // escape (.) otherwise (regex .) which means "any character".
        // double backslash needed to create a single backslash in the regex.
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int num1 = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.valueOf(v2[i]) : 0;
            if (num1 != num2) return num1 < num2 ? -1 : 1;
        }
        return 0;
    }
}
// t:n s:1
class Solution {
    public int compareVersion(String v1, String v2) {
        int i1 = 0;
        int i2 = 0;
        int s1 = 0;
        int s2 = 0;
        while (i1 < v1.length() && i2 < v2.length()) {
            s1 = 0;
            while (i1 < v1.length()) {
                if (v1.charAt(i1) == '.') {
                    i1++;
                    break;
                }
                s1 *= 10;
                s1 += v1.charAt(i1) - '0';
                i1++;
            }
            s2 = 0;
            while (i2 < v2.length()) {
                if (v2.charAt(i2) == '.') {
                    i2++;
                    break;
                }
                s2 *= 10;
                s2 += v2.charAt(i2) - '0';
                i2++;
            }
            if (s1 != s2) {
                return s1 < s2 ? -1 : 1;
            }
        }
        if (i1 == v1.length() && i2 == v2.length()) return 0;
        if (i1 == v1.length()) return checkAllZero(v2, i2) ? 0 : -1;
        return checkAllZero(v1, i1) ? 0 : 1;
    }
    
    private boolean checkAllZero(String str, int index) {
        while (index < str.length()) {
            if (str.charAt(index)!='0' && str.charAt(index)!='.') return false;
            index++;
        }
        return true;
    }
}