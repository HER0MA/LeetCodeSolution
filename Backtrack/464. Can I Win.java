// t:n*2^n s:n
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal<=0) return true;
        if (maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal) return false;
        // state[i]=='1' means number (i+1) has been used
        char[] state = new char[maxChoosableInteger];
        Arrays.fill(state, '0');
        return helper(state, desiredTotal, new HashMap<>());
    }
    private boolean helper(char[] state, int desiredTotal, Map<String, Boolean> map) {
        String stateKey = new String(state);
        if (map.containsKey(stateKey)) return map.get(stateKey);
        for (int i=0; i<state.length; i++) {
            if (state[i]=='0') {
                state[i] = '1';
                if (i+1>=desiredTotal || !helper(state, desiredTotal-i-1, map)) {
                    map.put(stateKey, true);
                    state[i]='0';
                    return true;
                }
                state[i] = '0';
            }
        }
        map.put(stateKey, false);
        return false;
    }
}