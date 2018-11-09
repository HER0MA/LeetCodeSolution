public class ZigzagIterator {
    Queue<Iterator<Integer>> queue;
    // t:1 (n for n lists)
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (!v1.isEmpty()) queue.offer(v1.iterator());
        if (!v2.isEmpty()) queue.offer(v2.iterator());
    }
    // t:1
    public int next() {
        Iterator<Integer> iterator = queue.poll();
        int res = iterator.next();
        if (iterator.hasNext()) queue.offer(iterator);
        return res;
    }
    // t:1
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */