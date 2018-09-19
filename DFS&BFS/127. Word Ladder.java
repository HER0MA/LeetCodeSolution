// t: (V+E)*len s:n
// BFS always find the shortest route
// Another method is store level in HashMap
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        if (set.contains(beginWord)) set.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while(queue.size()!=0) {
            int size = queue.size();
            for (int k=0; k<size; k++) { // loop one layer
                String word = queue.poll();
                for (int i=0; i<word.length(); i++) {
                    char[] charArr = word.toCharArray();
                    for (char ch='a'; ch<='z'; ch++) {
                        charArr[i] = ch;
                        String curr = new String(charArr);
                        if (set.contains(curr)) {
                            if (curr.equals(endWord)) {
                                return level+1;
                            }
                            set.remove(curr);
                            queue.offer(curr);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}