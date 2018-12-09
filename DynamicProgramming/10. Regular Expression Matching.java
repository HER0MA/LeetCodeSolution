// t:len(s)*len(p) s:len(s)*len(p)
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        /** Initialization
         * match[0][0] = true
         * match[i][0] = fales
         * match[0][j]=match[0][j-2] only when jth chars in p is '*'
         */
        match[0][0] = true;
        for (int j=2; j<=p.length(); j++) {
            if (p.charAt(j-1)=='*') {
                match[0][j] = match[0][j-2];
            }
        }
        for (int i=1; i<=s.length(); i++) {
            for (int j=1; j<=p.length(); j++) {
                if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') {
                    match[i][j] = match[i-1][j-1];
                } else if (p.charAt(j-1)=='*') {
                    // '*' matches 0 previous element -> match[i][j-2]
                    // '*' matches n previous element -> match[i-1][j]
                    // when char before '*' in p matches ith char in s
                    if (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.') {
                        match[i][j] = match[i-1][j] || match[i][j-2];
                    } else {
                        match[i][j] = match[i][j-2];
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }
}