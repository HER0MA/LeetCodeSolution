class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0) return false;
        // get all factors of s
        // then check if the fth char can be repeated to form the string s
        for (int i=1; i<=s.length()/2; i++) {
            if (s.length() % i == 0) {
                String temp = s.substring(0,i);
                StringBuilder sb = new StringBuilder(); // stringBuilder is more efficient than String + String
                int times = s.length() / i;
                for (int j=0; j<times; j++)
                    sb.append(temp);
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}