// t:n s:n
// Deque store values in descending order
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || nums.length==0) return nums;
        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i=0; i<nums.length; i++) {
            // first number in deque is out of the sliding window
            if (i-k>=0 && !deque.isEmpty() && deque.peekFirst()==nums[i-k]) {
                deque.pollFirst();
            }
            // removes all numbers less than nums[i] in deque
            while (!deque.isEmpty() && deque.peekLast()<nums[i]) {
                deque.pollLast();
            }
            // add nums[i] to deque
            deque.offerLast(nums[i]);
            // save result to result
            if (i-k+1>=0) {
                res[i-k+1] = deque.peekFirst();
            }
        }
        return res;
    }
}