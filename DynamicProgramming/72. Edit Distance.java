// t:l1*l2 s:l1*l2
/**
 * state[i][j] means min distance between
 * first i char of word1 and first j char of word2 (not index)
 * state[i][j] = min{ state[i-1][j]+1, state[i][j-1]+1, state[i-1][j-1]+1 } if word1[i]!=word2[j]
 *               min{ state[i-1][j]+1, state[i][j-1]+1, state[i-1][j-1]   } if word1[i]==word2[j]
 *                      delete/add          delete/add      replace
 * add and delete are same
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] state = new int[l1+1][l2+1];
        for (int i=1; i<=l1; i++) {
            state[i][0] = i;
        }
        for (int j=1; j<=l2; j++) {
            state[0][j] = j;
        }
        for (int i=1; i<=l1; i++) {
            for (int j=1; j<=l2; j++) {
                state[i][j] = Math.min(state[i-1][j], state[i][j-1]) + 1;
                if (word1.charAt(i-1)==word2.charAt(j-1)) {
                    state[i][j] = Math.min(state[i][j], state[i-1][j-1]);
                } else {
                    state[i][j] = Math.min(state[i][j], state[i-1][j-1]+1);
                }
            }
        }
        return state[l1][l2];
    }
}