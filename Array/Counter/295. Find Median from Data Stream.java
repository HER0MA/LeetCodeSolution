class MedianFinder {
    // large.size()==small.size() || large.size()==small.size()+1
    private PriorityQueue<Integer> small = new PriorityQueue<>( (a, b) -> b-a );
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    // t:logn
    public void addNum(int num) {
        // must modify two PQ to ensure correct in all circumstances
        large.offer(num);
        small.offer(large.poll());
        if (small.size() > large.size()) {
            large.offer(small.poll());
        }
    }
    // t:1
    public double findMedian() {
        // prevent overflow
        return large.size()>small.size() ? large.peek() : ((double)large.peek()+small.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */