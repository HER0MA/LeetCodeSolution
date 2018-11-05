// t:n^2 s:n^2
class Solution {
    public int minCut(String s) {
        if (s==null || s.length()==0) return 0;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int[] minNumOfCuts = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            int currNumOfCuts = i; // max number of cuts [0,i] is i
            for (int j=0; j<=i; j++) {
                // check if [j,i] is a palindrome
                if (s.charAt(j)==s.charAt(i) && (i-j<2 || isPalindrome[j+1][i-1])) {
                    isPalindrome[j][i] = true;
                    // j==0 -> [0, i] is palindrome, number of cuts = 0
                    currNumOfCuts = j==0 ? 0 : Math.min(currNumOfCuts, minNumOfCuts[j-1] + 1);
                }
            }
            minNumOfCuts[i] = currNumOfCuts;
        }
        return minNumOfCuts[s.length()-1];
    }
}