// ?t:n! s:n
class Solution {
    public List<Integer> diffWaysToCompute(String s) {
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*') {
                String pre = s.substring(0, i);
                String post = s.substring(i+1);
                List<Integer> preRes = diffWaysToCompute(pre);
                List<Integer> postRes = diffWaysToCompute(post);
                for (int preNum : preRes) {
                    for (int postNum : postRes) {
                        switch (s.charAt(i)) {
                            case '+' : res.add(preNum + postNum);
                                break;
                            case '-' : res.add(preNum - postNum);
                                break;
                            default : res.add(preNum * postNum);
                        }                        
                    }
                }
            }
        }
        if (res.size()==0) res.add(Integer.valueOf(s));
        return res;
    }
}