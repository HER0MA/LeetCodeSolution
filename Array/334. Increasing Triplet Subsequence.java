// t:n s:n
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sedMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num<=min) min = num;
            else if (num<=sedMin) sedMin = num;
            else return true;
        }
        return false;
    }
}