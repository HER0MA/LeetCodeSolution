// t:n s:n
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        // save #(tails of existing consecutive sequences)
        Map<Integer, Integer> tailNext = new HashMap<>();
        for (int n : nums) {
            if (freq.get(n) == 0) continue;
            if (tailNext.getOrDefault(n, 0) > 0) {
            // append to existing sequence
                freq.put(n, freq.get(n) - 1);
                tailNext.put(n, tailNext.get(n) - 1);
                tailNext.put(n + 1, tailNext.getOrDefault(n + 1, 0) + 1);
            } else if (freq.getOrDefault(n + 1, 0) > 0 
                       && freq.getOrDefault(n + 2, 0) > 0) {
            // create a new sequence
                freq.put(n, freq.get(n) - 1);
                freq.put(n + 1, freq.get(n + 1) - 1);
                freq.put(n + 2, freq.get(n + 2) - 1);
                tailNext.put(n + 3, tailNext.getOrDefault(n + 3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }
}