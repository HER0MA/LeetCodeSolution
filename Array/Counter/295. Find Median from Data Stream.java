class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // must modify two PQ to ensure correct in all circumstances
        large.add(num);
        small.add(-large.poll());
        if (small.size() > large.size()) {
            large.add(-small.poll());
        }
    }
    
    public double findMedian() {
        // prevent overflow
        return large.size()>small.size() ? large.peek() : -small.peek() + (double)(large.peek()+small.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */