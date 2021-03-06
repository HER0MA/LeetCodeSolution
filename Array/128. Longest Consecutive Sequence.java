// t:n s:n
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num-1)) {
                int len = 1;
                while (set.contains(num+1)) {
                    len++;
                    num++;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}