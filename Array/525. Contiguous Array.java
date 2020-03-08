// t:n s:n
class Solution {
    public int findMaxLength(int[] nums) {
        int diff = 0; // #0 - #1
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                diff++;
            } else {
                diff--;
            }
            if (map.containsKey(diff)) {
                res = Math.max(res, i - map.get(diff));
            } else {
                map.put(diff, i);
            }
        }
        return res;
    }
}