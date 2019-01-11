// t:4^n s:n^2
class Solution {
    private static char[][] numToChar = {{'a', 'b', 'c'}, 
                                         {'d', 'e', 'f'}, 
                                         {'g', 'h', 'i'}, 
                                         {'j', 'k', 'l'}, 
                                         {'m', 'n', 'o'}, 
                                         {'p', 'q', 'r', 's'}, 
                                         {'t', 'u', 'v'}, 
                                         {'w', 'x', 'y', 'z'}};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length()==0) return res;
        helper(digits, 0, new StringBuilder(), res);
        return res;
    }
    
    private void helper(String digits, int index, StringBuilder sb, List<String> res) {
        if (index==digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (char ch : numToChar[digits.charAt(index)-'2']) {
            sb.append(ch);
            helper(digits, index+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}