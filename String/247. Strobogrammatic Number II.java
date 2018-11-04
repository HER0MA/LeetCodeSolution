// t:5^(n/2) s:1
class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n==0) return res;
        helper(0, n-1, new char[n], res);
        return res;
    }
    
    private void helper (int left, int right, char[] str, List<String> res) {
        if (left>right) {
            res.add(new String(str));
        } else if (left==right) {
            str[left] = '0';
            res.add(new String(str));
            str[left] = '1';
            res.add(new String(str));
            str[left] = '8';
            res.add(new String(str));
        } else {
            if (left!=0) {
                str[left] = '0';
                str[right] = '0';
                helper(left+1, right-1, str, res);
            }
            str[left] = '1';
            str[right] = '1';
            helper(left+1, right-1, str, res);
            str[left] = '6';
            str[right] = '9';
            helper(left+1, right-1, str, res);
            str[left] = '8';
            str[right] = '8';
            helper(left+1, right-1, str, res);
            str[left] = '9';
            str[right] = '6';
            helper(left+1, right-1, str, res);
        }
    }
}