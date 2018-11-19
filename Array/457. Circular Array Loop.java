// t:n s:1
// fast slow pointer
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==0) continue;
            int slow = i;
            int fast = i;
            int fastNext = getNext(fast, nums);
            int fastNextNext = getNext(fastNext, nums);
            // same direction
            while (nums[fast]*nums[fastNext]>0 && nums[fastNext]*nums[fastNextNext]>0) {
                slow = getNext(slow, nums);
                fast = fastNextNext;
                fastNext = getNext(fast, nums);
                fastNextNext = getNext(fastNext, nums);
                if (fast == slow) {
                    // single element circle
                    if (fast==fastNext) break;
                    // find a circle
                    return true;
                }
            }
            // not a circle, set all visited index zero
            slow = i;
            while (nums[slow]*nums[getNext(slow, nums)]>0) {
                nums[slow] = 0;
                slow = getNext(slow, nums);
            }
        }
        return false;
    }
    private int getNext(int index, int[] nums) {
        return index+nums[index]<0 ? nums.length+(index+nums[index])%nums.length : (index+nums[index])%nums.length;
    }
}