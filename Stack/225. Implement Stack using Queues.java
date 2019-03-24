// s:n
class MyStack {
    Queue<Integer> queue = new LinkedList<>();
    
    /** Push element x onto stack. */
    // t:n
    public void push(int x) {
        queue.offer(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.offer(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    // t:1
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    // t:1
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    // t:1
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */