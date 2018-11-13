class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, 0, new char[]{'(', ')'}, res);
        return res;
    }
    private void helper(String s, int lastChecked, int lastRemoved, char[] pair, List<String> res) {
        int count = 0;
        for (int checkIdx=lastChecked; checkIdx<s.length(); checkIdx++) {
            if (s.charAt(checkIdx)==pair[0]) count++;
            else if (s.charAt(checkIdx)==pair[1]) count--;
            if (count>=0) continue; 
            // loop until there are one more ')' than '('
            // remove one ')'
            for (int removeIdx=lastRemoved; removeIdx<=checkIdx; removeIdx++) {
                // only remove first ')' in a series of concecutive ')'
                if (s.charAt(removeIdx)==pair[1] && (removeIdx==lastRemoved || s.charAt(removeIdx-1)!=pair[1])) {
                    String removed = s.substring(0,removeIdx)+s.substring(removeIdx+1);
                    // after remove each element move forward, so no duplicate checkIdx and removeIdx
                    helper(removed, checkIdx, removeIdx, pair, res);
                }
            }
            // end the loop when try all possible ways of removing ')'
            // recursive helper will remove other extra ')' 
            return;
        }
        // if not return, all prefix of s has more '(' than ')'
        String reversed = new StringBuilder(s).reverse().toString();
        if (pair[0]=='(') {
            // original string process finished
            // reverse string and process again
            helper(reversed, 0, 0, new char[]{')', '('}, res);
        } else {
            // reversed string process finished
            // reverse back and add to res
            res.add(reversed);
        }
    }
}