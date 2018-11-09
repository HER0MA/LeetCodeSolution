class MovingAverage {
    private Queue<Integer> queue;
    private double sum;
    private int size;

    // t:1
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }
    // t:1
    public double next(int val) {
        if (queue.size()==size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */