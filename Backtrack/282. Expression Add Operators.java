// ?t:4^n ?s:4^n
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper("", 0, 0, 0, num, target, res);
        return res;
    }
    
    private void helper(String path, long val, long prev, int idx, String num, int target, List<String> res) {
        if (idx==num.length()) {
            if (val==target) res.add(path);
            return;
        }
        
        for (int i=idx; i<num.length(); i++) {
        	// if current number starts with 0, only "0" is valid
            if (i!=idx && num.charAt(idx)=='0') break;
            long curr = Long.valueOf(num.substring(idx, i+1));
            if (idx==0) {
                helper(path+curr, curr, curr, i+1, num, target, res);
            } else {
                helper(path+'+'+curr, val+curr,           curr,      i+1, num, target, res);
                helper(path+'-'+curr, val-curr,          -curr,      i+1, num, target, res);
                helper(path+'*'+curr, val-prev+curr*prev, curr*prev, i+1, num, target, res);
            }
        }
    }
}