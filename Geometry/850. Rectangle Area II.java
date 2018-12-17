// t:n^2 s:n
// sweep line, sweep over x axis
class Solution {
    private static int M = 1000000007;
    
    public int rectangleArea(int[][] rectangles) {
        List<int[]> points = new ArrayList<>();
        for (int[] rectangle : rectangles) {
        	// [x, y, value]
        	// two left points, value is 1 for start point and -1 for end point (y low to high)
            points.add(new int[]{rectangle[0], rectangle[1],  1});
            points.add(new int[]{rectangle[0], rectangle[3], -1});
            // two right points, value is negation of its left correspondence
            points.add(new int[]{rectangle[2], rectangle[1], -1});
            points.add(new int[]{rectangle[2], rectangle[3],  1});
        }
        // sort according to x coordinate
        // sort y coordinate just for faster when added to TreeMap
        Collections.sort(points, (a,b) -> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int prevX = points.get(0)[0];
        int prevY = 0;
        int res = 0;
        for (int i=0; i<points.size(); i++) {
            int[] p = points.get(i);
            map.put(p[1], map.getOrDefault(p[1], 0)+p[2]);
            // when all points of current x coordinate have been added to TreeMap
            if (i==points.size()-1 || points.get(i+1)[0]>p[0]) {
                res += ((long)prevY * (p[0] - prevX)) % M;
                res %= M;
                prevY = getLength(map);
                prevX = p[0];
            }
        }
        return res;
    }
    // get the length of y, algorithm similar to meeting room
    private int getLength(TreeMap<Integer, Integer> map) {
        int count = 0;
        int prev = 0;
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count > 0) {
                res += entry.getKey() - prev;
            }
            count += entry.getValue();
            prev = entry.getKey();
        }
        return res;
    }
}