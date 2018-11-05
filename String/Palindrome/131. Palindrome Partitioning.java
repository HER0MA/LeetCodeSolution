// t:2^n s:n
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s==null || s.length()==0) return res;
        helper(s, new ArrayList<>(), res);
        return res;
    }
    
    private void helper(String s, List<String> list, List<List<String>> res) {
        if (s.length()==0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=1; i<=s.length(); i++) {
            String prefix = s.substring(0, i);
            if (isPalindrome(prefix)) {
                list.add(prefix);
                helper(s.substring(i), list, res);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        while (i<j) {
            if (s.charAt(i)!=s.charAt(j)) return false;
            i ++;
            j --;
        }
        return true;
    }
}