// t:(V+E)*len s:n^2
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        /**
         * Undirected Graph -(BFS)-> tree -(DFS)-> solution
         * 
         * map for store parent-children relationship
         * 
         * visited and unvisited makes a node 
         * can be visited by all nodes within one letter difference in its upper layer
         * but can not be visited by node in other layers 
         * (even with one letter difference, avoid visit parent)
         *
         * queue for BFS
         */
        List<List<String>> res = new ArrayList<>();
        if (wordList==null || wordList.size()==0 || !wordList.contains(endWord)) return res;
        
        Map<String, List<String>> map = new HashMap<>();

        Set<String> visited = new HashSet<>();
        Set<String> unvisited = new HashSet<>(wordList);
        if (unvisited.contains(beginWord)) unvisited.remove(beginWord);
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        while (queue.size()!=0) {
            int size = queue.size();
            for (int k=0; k<size; k++) { // loop one layer
                String currWord = queue.poll();
                for (int i=0; i<currWord.length(); i++) {
                    char[] charArr = currWord.toCharArray();
                    for (char ch='a'; ch<='z'; ch++) {
                        charArr[i]=ch;
                        String nextWord = new String(charArr);
                        if (unvisited.contains(nextWord)) {
                            if (visited.add(nextWord)) {
                                // if visited.add() return false
                                // then nextWord has already in queue
                                queue.offer(nextWord);
                            }
                            if (map.containsKey(currWord)) {
                                map.get(currWord).add(nextWord);
                            } else {
                                List<String> currList = new ArrayList<>();
                                currList.add(nextWord);
                                map.put(currWord, currList);
                            }
                        }
                    }
                }
            }
            // set visited and unvisited for next layer
            unvisited.removeAll(visited);
            visited.clear();
        }
        
        dfs(beginWord, endWord, map, new ArrayList<String>(), res);
        return res;
    }
    private void dfs(String currWord, String endWord, Map<String, List<String>> map, List<String> list, List<List<String>> res) {
        if (currWord.equals(endWord)) {
            list.add(endWord);
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        if (map.containsKey(currWord)) {
            list.add(currWord);
            for (String nextWord : map.get(currWord)) {
                dfs(nextWord, endWord, map, list, res);
            }
            list.remove(currWord);
        }
    }
}

// Optimized DFS, Time Limit Exceeded
class Solution {
    private int minLen;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!set.contains(endWord)) return res;
        if (set.contains(beginWord)) set.remove(beginWord);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        minLen = Integer.MAX_VALUE;
        helper(beginWord, 1, endWord, list, set, res);
        for (int i=0; i<res.size(); ) {
            if (res.get(i).size()!=minLen) {
                res.remove(i);
            } else {
                i++;
            }
        }
        return res;
    }
    private void helper(String beginWord, int len, String endWord, List<String> curr, Set<String> set, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(curr));
            minLen = Math.min(minLen, len);
            return;
        }
        if (len>minLen) return;
        if (set.size()==0) return;
        for (int i=0; i<beginWord.length(); i++) {
            char[] charArr = beginWord.toCharArray();
            for (char c='a'; c<='z'; c++) {
                charArr[i] = c;
                String temp = new String(charArr);
                if (set.contains(temp)) {
                    curr.add(temp);
                    set.remove(temp);
                    helper(temp, len+1, endWord, curr, set, res);
                    curr.remove(curr.size()-1);
                    set.add(temp);
                }
            }
        }
    }
}