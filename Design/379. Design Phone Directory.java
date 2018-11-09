class PhoneDirectory {
    private Queue<Integer> queue;
    private Set<Integer> used;
    private int max;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    // t:n
    public PhoneDirectory(int maxNumbers) {
        queue = new LinkedList<>();
        used = new HashSet<>();
        max = maxNumbers;
        for (int i=0; i<max; i++) {
            queue.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    // t:1
    public int get() {
        if (queue.isEmpty()) return -1;
        int res = queue.poll();
        used.add(res);
        return res;
    }
    
    /** Check if a number is available or not. */
    // t:1
    public boolean check(int number) {
        return number>=0 && number<max && !used.contains(number);
    }
    
    /** Recycle or release a number. */
    // t:1
    public void release(int number) {
        if (used.remove(number)) {
            queue.offer(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */