// Dynamic Programming
// t:len(s)*len(p) s:len(s)*len(p)
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        /** Initialization
         * match[0][0] = true
         * match[i][0] = fales
         * match[0][j]=true only when first j chars in p are all '*'
         */
        match[0][0] = true;
        for (int j=1; j<=p.length(); j++) {
            if (p.charAt(j-1)!='*') break;
            match[0][j] = match[0][j-1];
        }
        for (int i=1; i<=s.length(); i++) {
            for (int j=1; j<=p.length(); j++) {
                if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?') {
                    match[i][j] = match[i-1][j-1];
                } else if (p.charAt(j-1)=='*') {
                    // '*' matches empty -> match[i][j-1]
                    // '*' matches current char in s -> match[i-1][j]
                    match[i][j] = match[i-1][j] || match[i][j-1];
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
// Greedy
// t:n s:n
class Solution {
    public boolean isMatch(String s, String p) {
        int sp = 0;
        int pp = 0;
        int starIdx = -1;
        // index befrore lastStarMatch are all matched by '*'
        int lastStarMatch = 0;
        while (sp<s.length()) {
            if (pp<p.length() && (s.charAt(sp)==p.charAt(pp) || p.charAt(pp)=='?')) {
                sp ++;
                pp ++;
            } else if (pp<p.length() && p.charAt(pp)=='*') {
                starIdx = pp;
                // initially '*' matches zero char
                lastStarMatch = sp;
                pp ++;
            } else if (starIdx!=-1) {
                // if not match, we move back to star
                pp = starIdx+1;
                // make star match one more char
                lastStarMatch ++;
                sp = lastStarMatch;
            } else {
                return false;
            }
        }
        while (pp < p.length() && p.charAt(pp) == '*') {
            pp++;
        }
        return pp==p.length();
    }
}