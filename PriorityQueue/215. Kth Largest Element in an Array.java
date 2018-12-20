// Quick Select
// t:n^2(worst) n(average) s:1
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length-1;
        int target = nums.length-k;
        while (start < end) {
            int pivot = partition(nums, start, end);
            if (pivot == target) return nums[pivot];
            if (pivot < target) start = pivot+1;
            else end = pivot - 1;
        }
        // becuase start<=target<=end
        // if pivot!=target, then start<pivot<end
        // so the loop will end in start==end
        return nums[start];
    }
    
    private int partition(int[] nums, int start, int end) {
        int pivot = start++;
        while (start <= end) {
            while (start<=end && nums[start]<=nums[pivot]) start ++;
            while (start<=end && nums[end]>=nums[pivot]) end --;
            if (start > end) break;
            swap(nums, start++, end--);
        }
        // nums[end]<nums[pivot] || (end==start && nums[end]==nums[pivot])
        swap(nums, pivot, end);
        return end;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// Priority Queue
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