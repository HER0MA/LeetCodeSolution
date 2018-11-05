// t:(n/2)! s:n
class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int odd = 0; // record number of char which appears odd times
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            odd += map.get(s.charAt(i))%2==0 ? -1 : 1 ; 
        }
        if (odd>1) return res;
        
        // permutation with duplicate
        // for each char, only use half times
        List<Character> list = new ArrayList<>();
        String mid = ""; // record one single char (if exists) in the middle
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val%2==1) mid += key;
            for (int i=0; i<val/2; i++) {
                list.add(key);
            }
        }
        helper(new StringBuilder(), new boolean[list.size()], list, res, mid);
        return res;        
    }
    // Similar to 47. Permutations II
    private void helper(StringBuilder sb, boolean[] used, List<Character> list, List<String> res, String mid) {
        if (sb.length()==list.size()) {
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
        for (int i=0; i<list.size(); i++) {
            if (used[i] || i>0 && list.get(i-1)==list.get(i) && !used[i-1]) continue;
            sb.append(list.get(i));
            used[i] = true;
            helper(sb, used, list, res, mid);
            used[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}