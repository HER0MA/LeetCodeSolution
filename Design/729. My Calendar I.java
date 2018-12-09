// TreeMap: key:start value:end
class MyCalendar {
    private TreeMap<Integer, Integer> intervals;

    public MyCalendar() {
        intervals = new TreeMap<>();
    }
    // t:logn
    public boolean book(int start, int end) {
        if (intervals.containsKey(start)) return false;
        Integer prevStart = intervals.lowerKey(start);
        if (prevStart!=null && intervals.get(prevStart)>start) return false;
        Integer nextStart = intervals.higherKey(start);
        if (nextStart!=null && nextStart<end) return false;
        intervals.put(start, end);
        return true;
    }
}