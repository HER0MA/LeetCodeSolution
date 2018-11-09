public class Vector2D implements Iterator<Integer> {
    private Queue<Iterator<Integer>> queue;
    Iterator<Integer> iter;
    // t:n
    public Vector2D(List<List<Integer>> vec2d) {
        queue = new LinkedList<>();
        for (List<Integer> list : vec2d) {
            if (!list.isEmpty()) {
                queue.offer(list.iterator());
            }
        }
        if (!queue.isEmpty()) {
            iter = queue.poll();
        }
    }
    // t:1
    @Override
    public Integer next() {
        if (iter.hasNext()) return iter.next();
        iter = queue.poll();
        return iter.next();
    }
    // t:1
    @Override
    public boolean hasNext() {
        return iter!=null && iter.hasNext() || !queue.isEmpty();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */