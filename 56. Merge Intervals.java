/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/*  顺序排列所有的start和end
    根据start和end的关系判断是否合并
*/

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1) return intervals;
        int length = intervals.size();
        int[] start = new int[length];
        int[] end = new int[length];
        int i=0;
        for(Interval inte : intervals){
            start[i] = inte.start;
            end[i] = inte.end;
            i++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<Interval> ans = new LinkedList<Interval>();
        Interval temp = null;
        int startTemp = 0;
        int endTemp = 0;
        for(int j=0; j+1<length; j++){
            startTemp = start[j];
            while(j+1<length && end[j]>=start[j+1]){
                j++;
            }
            endTemp = end[j];
            temp = new Interval(startTemp, endTemp);
            ans.add(temp);
        }
        if(ans.get(ans.size()-1).end!=end[length-1]){
            startTemp = start[length-1];
            endTemp = end[length-1];
            temp = new Interval(startTemp, endTemp);
            ans.add(temp);
        }
        return ans;
    }
}