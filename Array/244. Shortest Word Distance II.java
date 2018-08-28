class WordDistance {
    
    private Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for (int i=0; i<words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> currList = new ArrayList<>();
                currList.add(i);
                map.put(words[i], currList);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        int i1 = 0, i2 = 0;
        while (i1<l1.size() && i2<l2.size()) {
            int index1 = l1.get(i1);
            int index2 = l2.get(i2);
            res = Math.min(res, Math.abs(index1-index2));
            if (index1<index2) {
                i1++;
            } else {
                i2++;
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */