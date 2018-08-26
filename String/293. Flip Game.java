// t:n s:n
public class Solution {
    /**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     */
    public List<String> generatePossibleNextMoves(String s) {
        // write your code here
        List<String> ans = new ArrayList<>();
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i)=='+' && s.charAt(i-1)=='+') {
                ans.add(s.substring(0, i-1)+"--"+s.substring(i+1));
            }
        }
        return ans;
    }
}