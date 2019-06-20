// t: n s:n
// reverse subarray when there is 'D'
class Solution {
    public int[] findPermutation(String s) {
        int[] res = new int[s.length() + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                start = i;
                while (++i < s.length() && s.charAt(i) == 'D');
                reverse(res, start, i);
            }
        }
        return res;
    }
    
    private void reverse(int[] res, int start, int end) {
        while (start < end) {
            int temp = res[start];
            res[start++] = res[end];
            res[end--] = temp;
        }
    }
}