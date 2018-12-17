// t:nlogn s:n
class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();
        for (int[] building : buildings) {
            // start point -> [x, -height]
            // end   point -> [x,  height]
            points.add(new int[]{building[0], -building[2]});
            points.add(new int[]{building[1], building[2]});
        }
        // sort according to x value, if x is same
        // first start then end
        // start points, high to low, update to highest directly
        // end points, low to high, do not record lower point in result
        Collections.sort(points, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0] );
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> b-a );
        List<int[]> res = new ArrayList<>();
        int curr = 0;
        int highest = 0;
        pq.offer(0);
        for (int[] point : points) {
            if (point[1] > 0) { // end point, remove height
                pq.remove(point[1]);
            } else { // start point, add height
                pq.offer(-point[1]);
            }
            curr = pq.peek();
            if (curr != highest) { // highest is changed
                res.add(new int[]{point[0], curr});
                highest = curr;
            }
        }
        return res;
    }
}