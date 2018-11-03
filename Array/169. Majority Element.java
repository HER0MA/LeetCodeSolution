// t:n s:1
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (candidate == num) {
                count ++;
            } else if (count==0) {
                candidate = num;
                count = 1;
            } else {
                count --;
            }
        }
        return candidate;
    }
}