// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer next;
    // t:n
	public PeekingIterator(Iterator<Integer> iterator) {
	    iter = iterator;
        if (iter.hasNext()) {
            next = iter.next();
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	// t:1
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	// t:1
	@Override
	public Integer next() {
	    Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
	}
	// t:1
	@Override
	public boolean hasNext() {
	    return next != null;
	}
}