class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        // loop B.length()/A.length()+2 times
        // (postfix of A) + A + A + ... + A + (prefix of A)
        for (int i=0; i<B.length()/A.length()+2; i++) {
            sb.append(A);
            if (sb.toString().contains(B)) {
                return i+1;
            }
        }
        return -1;
    }
}