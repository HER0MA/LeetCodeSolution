/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// t:n s:1
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals==null || intervals.length<2) return true;
        Arrays.sort(intervals, (a,b) -> a.start-b.start);
        int end = intervals[0].end;
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i].start<end) {
                return false;
            }
            end = intervals[i].end;
        }
        return true;
    }
}