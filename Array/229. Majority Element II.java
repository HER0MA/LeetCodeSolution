// t:n s:1
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (num==candidate1) {
                count1 ++;
            } else if (num==candidate2) {
                count2 ++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }else {
                count1 --;
                count2 --;
            }
        }
        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1 ++;
            } else if (num == candidate2) {
                count2 ++;
            }
        }
        if (count1 > nums.length/3) {
            res.add(candidate1);
        }
        if (count2 > nums.length/3) {
            res.add(candidate2);
        }
        return res;
    }
}