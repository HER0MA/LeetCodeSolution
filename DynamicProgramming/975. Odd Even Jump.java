// t:logn s:n
class Solution {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];
        higher[n - 1] = true;
        lower[n - 1] = true;
        int res = 1;
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> hEntry = map.ceilingEntry(A[i]);
            Map.Entry<Integer, Integer> lEntry = map.floorEntry(A[i]);
            if (hEntry != null) higher[i] = lower[hEntry.getValue()];
            if (lEntry != null) lower[i] = higher[lEntry.getValue()];
            if (higher[i]) res++;
            map.put(A[i], i);
        }
        return res;
    }
}