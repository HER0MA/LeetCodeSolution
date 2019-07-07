// t:n s:1
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0;
        int maxCount = 0;
        for (char ch : tasks) {
            count[ch - 'A']++;
            if (count[ch - 'A'] > max) {
                max = count[ch - 'A'];
                maxCount = 1;
            } else if (count[ch - 'A'] == max) {
                maxCount++;
            }
        }
        // can fill more than n tasks between two same tasks
        int intervalCount = max - 1;
        int intervalLength = n - maxCount + 1;
        int slotCount = intervalCount * intervalLength;
        // try to fill all empty slots
        int idleCount = Math.max(0, slotCount - (tasks.length - max * maxCount));
        
        return tasks.length + idleCount;
    }
}
// t:n s:1
// 358. Rearrange String k Distance Apart
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int[] next = new int[26];
        for (char ch : tasks) {
            count[ch - 'A']++;
        }
        boolean finished = false;
        int idx = 0;
        while (!finished) {
            int currChar = -1;
            int max = 0;
            for (int i = 0; i < 26; i++) {
                if (count[i] > max && idx >= next[i]) {
                    max = count[i];
                    currChar = i;
                }
            }
            if (currChar != -1) {
                count[currChar]--;
                next[currChar] = idx + n + 1;
            }
            idx++;
            finished = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    finished = false;
                    break;
                }
            }
        }
        return idx;
    }
}