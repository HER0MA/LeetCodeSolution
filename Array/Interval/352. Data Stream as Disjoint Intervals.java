/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {
    private TreeMap<Integer, Interval> treeMap;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        treeMap = new TreeMap<>();
    }
    // t:logn
    public void addNum(int val) {
        if (treeMap.containsKey(val)) return;
        Integer lowerKey = treeMap.lowerKey(val);
        Integer higherKey = treeMap.higherKey(val);
        if (lowerKey!=null && higherKey!=null && val-1==treeMap.get(lowerKey).end 
                                              && val+1==treeMap.get(higherKey).start) {
            treeMap.get(lowerKey).end = treeMap.get(higherKey).end;
            treeMap.remove(higherKey);
        } else if (lowerKey!=null && val<=treeMap.get(lowerKey).end+1) {
            treeMap.get(lowerKey).end = Math.max(val, treeMap.get(lowerKey).end);
        } else if (higherKey!=null && val+1==treeMap.get(higherKey).start) {
            treeMap.put(val, new Interval(val, treeMap.get(higherKey).end));
            treeMap.remove(higherKey);
        } else {
            treeMap.put(val, new Interval(val, val));
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>(treeMap.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */