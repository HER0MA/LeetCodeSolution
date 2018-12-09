// Quick Select

// t:nlogk s:k
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // there are k elements in pq, return samllest of them
        return pq.poll();
    }
}