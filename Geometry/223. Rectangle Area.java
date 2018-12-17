// t:1 s:1
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int res = (C-A)*(D-B) + (G-E)*(H-F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int up = Math.min(D, H);
        int down = Math.max(B, F);
        if (right>left && up>down) {
            res -= (right-left)*(up-down);
        }
        return res;
    }
}