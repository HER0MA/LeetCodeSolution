// t:nlogk s:n
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums.length==0) return new double[0];
        // large.size()==small.size() || large.size()==small.size()+1
        PriorityQueue<Integer> large = new PriorityQueue<>();
        // lambda function "(a,b) -> b-a" will overflow when input contains large integers
        PriorityQueue<Integer> small = new PriorityQueue<>( 
            new Comparator<Integer>() {
                public int compare(Integer i1, Integer i2) {
                    return i2.compareTo(i1);
                }
            }
        );
        
        double[] res = new double[nums.length-k+1];
        for (int i=0; i<nums.length; i++) {
            add(nums[i], small, large);
            if (i>=k) {
                remove(nums[i-k], small, large);
            }
            if (i-k+1>=0) {
                res[i-k+1] = getMedian(small, large);
            }
        }
        return res;
    }
    // t:logk
    private void add(int num, PriorityQueue<Integer> small, PriorityQueue<Integer> large) {
        large.offer(num);
        small.offer(large.poll());
        if (small.size() > large.size()) {
            large.offer(small.poll());
        }
    }
    // t:logk
    private void remove(int num, PriorityQueue<Integer> small, PriorityQueue<Integer> large) {
        if (num < getMedian(small, large)) {
            small.remove(num);
            if (large.size() > small.size()+1) {
                small.offer(large.poll());
            }
        } else {
            large.remove(num);
            if (small.size() > large.size()) {
                large.offer(small.poll());
            }
        }
    }
    // t:1
    private double getMedian(PriorityQueue<Integer> small, PriorityQueue<Integer> large) {
        return large.size()>small.size() ? large.peek() : ((double)large.peek()+small.peek())/2;
    }
}