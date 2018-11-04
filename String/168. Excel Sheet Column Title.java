class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while (n>0) {
            n --;
            res = (char)('A'+n%26) + res;
            n /= 26;
        }
        return res;
    }
}

class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while (n>0) {
            if (n%26==0) {
                res = 'Z' + res;
                n /= 26;
                n --;
            } else {
                res = (char)('A'+n%26-1) + res;
                n /= 26;
            }
        }
        return res;
    }
}