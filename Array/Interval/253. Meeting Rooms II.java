/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 // t:n s:n
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int res = 0;
        int roomNum = 0;
        for (int i=0, j=0; i<starts.length; ) {
            if (starts[i]<ends[j]) {
                roomNum++;
                res = Math.max(res, roomNum);
                i++;
            } else {
                roomNum--;
                j++;
            }
        }
        return res;
    }
}