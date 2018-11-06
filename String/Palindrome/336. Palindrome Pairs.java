// t:n*k^2 s:n
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words==null || words.length==0) return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            map.put(words[i], i);
        }
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<=words[i].length(); j++) {
                String prefix = words[i].substring(0, j); // 0~j-1
                String postfix = words[i].substring(j); // j~end
                if (isPalindrome(prefix)) {
                    String reversedPostfix = new StringBuilder(postfix).reverse().toString();
                    if (map.containsKey(reversedPostfix) && map.get(reversedPostfix)!=i) {
                        res.add(Arrays.asList(map.get(reversedPostfix), i));
                    }
                }
                // len(postfix)!=0 prevent duplicate
                if (postfix.length()!=0 && isPalindrome(postfix)) {
                    String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                    if (map.containsKey(reversedPrefix) && map.get(reversedPrefix)!=i) {
                        res.add(Arrays.asList(i, map.get(reversedPrefix)));
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        while (i<j) {
            if (s.charAt(i)!=s.charAt(j)) {
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }
}