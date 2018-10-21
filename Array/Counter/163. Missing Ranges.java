// t:n s:1
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        // prevent overflow when num is MAX_VALUE
        long start = lower;
        for (int num : nums) {
            if (num==start) {
                start++;
            } else if (num>start) {
                if (start+1==num) {
                    res.add(""+start);
                } else {
                    res.add(start+"->"+(num-1));
                }
                start = (long)num+1;
            }
        }
        if (start==upper) res.add(""+start);
        else if (start<upper) res.add(start+"->"+upper);
        return res;
    }
}