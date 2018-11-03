// ?t:2^n s:n
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(0, n, new StringBuilder(), res);
        return res;
    }
    private void helper(int k, int n, StringBuilder sb, List<String> res) {
        if (sb.length()==n*2) {
            res.add(sb.toString());
            return;
        }
        if (k<n) {
            sb.append('(');
            helper(k+1, n, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
        if (sb.length()<k*2) {
            sb.append(')');
            helper(k, n, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}