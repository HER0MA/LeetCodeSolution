// t:n s:1
// prev: start of last continue value
class Solution {
    public int totalFruit(int[] tree) {
        int res = 0;
        int count = 0;
        int prev = 0;
        int f1 = tree[0];
        int f2 = tree[0];
        for (int i=0; i<tree.length; i++) {
            if (tree[i]==f1 || tree[i]==f2) {
                count ++;
            } else if (f1==f2) {
                count ++;
                f2 = tree[i];
            } else {
                count = i-prev+1;
                f2 = tree[i];
                f1 = tree[prev]; // must update to prev
            }
            res = Math.max(res, count);
            prev = tree[i]==tree[prev] ? prev : i;
        }
        return res;
    }
}