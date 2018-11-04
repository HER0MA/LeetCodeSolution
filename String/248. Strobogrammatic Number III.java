class Solution {
    private int res;
    private String low;
    private String high;
    
    public int strobogrammaticInRange(String low, String high) {
        res = 0;
        this.low = low;
        this.high = high;
        for (int n=low.length(); n<=high.length(); n++) {
            helper(0, n-1, new char[n]);
        }
        return res;
    }
    
    private void helper (int left, int right, char[] str) {
        if (left>right) {
            processNum(str);
        } else if (left==right) {
            str[left] = '0';
            processNum(str);
            str[left] = '1';
            processNum(str);
            str[left] = '8';
            processNum(str);
        } else {
            if (left!=0) {
                str[left] = '0';
                str[right] = '0';
                helper(left+1, right-1, str);
            }
            str[left] = '1';
            str[right] = '1';
            helper(left+1, right-1, str);
            str[left] = '6';
            str[right] = '9';
            helper(left+1, right-1, str);
            str[left] = '8';
            str[right] = '8';
            helper(left+1, right-1, str);
            str[left] = '9';
            str[right] = '6';
            helper(left+1, right-1, str);
        }
    }
    private void processNum(char[] str) {
        String currStr = new String(str);
        if (!(str.length==low.length() && currStr.compareTo(low)<0 || 
              str.length==high.length() && currStr.compareTo(high)>0)) {
            res ++;
        }
    }
}