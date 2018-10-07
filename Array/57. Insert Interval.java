/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

/** newInterval will not affect 
 *  intervals whose start larger than newInterval.end and 
 *  intervals whose end less than newInterval.start
 */
// t:n s:n
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval==null) return intervals;
        List<Interval> res = new ArrayList<>();
        int i=0;
        // intervals whose start larger than newInterval.end
        while (i<intervals.size() && intervals.get(i).end<newInterval.start) {
            res.add(intervals.get(i++));
        }
        if (i<intervals.size()) { 
        // else, newInterval.start > all end, newInterval is last interval after insert
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        }
        while (i<intervals.size() && intervals.get(i).start<=newInterval.end) {
            i++;
        }
        if (i-1>=0) { 
        // else, newInterval.end < all start, newInterval is first interval after insert
            newInterval.end = Math.max(newInterval.end, intervals.get(i-1).end);
        }
        res.add(newInterval);
        // intervals whose end less than newInterval.start
        while (i<intervals.size()) {
            res.add(intervals.get(i++));
        }
        return res;
    }
}

class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals==null) return intervals;
        int start = 0;
        int end = 0;
        boolean startFound = false;
        boolean endFound = false;
        int insertPos = 0;
        for (int i=0; i<intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (!startFound && newInterval.start<=interval.end) {
                if (newInterval.start<interval.start) {
                    start = newInterval.start;
                } else {
                    start = interval.start;
                }   
                startFound = true;
                insertPos = i;
            }
            if (!endFound && newInterval.end<=interval.end) {
                if (newInterval.end<interval.start) {
                    end = newInterval.end;
                } else {
                    end = interval.end;
                    intervals.remove(i);
                    i--;
                }
                endFound = true;
            }
            if (startFound && !endFound) {
                intervals.remove(i);
                i--;
            }
        }
        if (!startFound) {
            start = newInterval.start;
            insertPos = intervals.size();
        }
        if (!endFound) end = newInterval.end;
        intervals.add(insertPos, new Interval(start, end));
        return intervals;
    }
}