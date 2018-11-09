class HitCounter {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    // t:1
    public HitCounter() {
        queue = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    // t:1
    public void hit(int timestamp) {
        queue.offer(timestamp+300);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    // t:n
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && queue.peek() <= timestamp) {
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */