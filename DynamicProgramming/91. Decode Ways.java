// t:n s:n
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int[] state = new int[s.length() + 1];
        // state[i] number of decode ways in first ith char
        state[0] = 1;
        state[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            // index is i-1
            int num = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (num == 0) return 0;
            if (num < 10) {
                state[i] = state[i - 1];
            } else if (num == 10 || num == 20) {
                state[i] = state[i - 2];
            } else if (num <= 26) {
                state[i] = state[i - 1] + state[i - 2];
            } else if (num % 10 == 0) {
                return 0;
            } else {
                state[i] = state[i - 1];
            }
        }
        return state[s.length()];
    }
}
// t:n s:1
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int prev2 = 1;
        int prev1 = s.charAt(0) == '0' ? 0 : 1;
        int curr = prev1;
        for (int i = 2; i <= s.length(); i++) {
            // index is i-1
            int num = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (num == 0) return 0;
            if (num < 10) {
                curr = prev1;
            } else if (num == 10 || num == 20) {
                curr = prev2;
            } else if (num <= 26) {
                curr = prev1 + prev2;
            } else if (num % 10 == 0) {
                return 0;
            } else {
                curr = prev1;
            }
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}