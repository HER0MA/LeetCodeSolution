// t:n s:1
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] state = new int[days[days.length - 1] + 1];
        int idx = 0;
        for (int i = 1; i < state.length; i++) {
            if (i < days[idx]) {
                state[i] = state[i - 1];
            } else {
                state[i] = state[i - 1] + costs[0];
                state[i] = Math.min(state[i], state[i > 7 ? i - 7 : 0] + costs[1]);
                state[i] = Math.min(state[i], state[i > 30 ? i - 30 : 0] + costs[2]);
                idx++;
            }
        }
        return state[state.length - 1];
    }
}