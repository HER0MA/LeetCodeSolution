/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// t:nlogn s:n
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals==null || intervals.size()<2) return intervals;
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, (a, b) -> a.start-b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start<=end) {
                end = Math.max(end, interval.end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, (a, b) -> a.start==b.start ? b.end-a.end : a.start-b.start );
        int i = 0;
        while (i<intervals.size()) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            i ++;
            while (i<intervals.size() && intervals.get(i).start<=end) {
                end = Math.max(end, intervals.get(i).end);
                i ++;
            }
            res.add(new Interval(start, end));
        }
        return res;
    }
}