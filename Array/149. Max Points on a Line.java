/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
// t:n^2 s:n
class Solution {
    public int maxPoints(Point[] points) {
        if (points==null) return 0;
        if (points.length<3) return points.length;
        // sort in order to caculate sameX, samePos first
        Arrays.sort(points, (a, b) -> a.x-b.x);
        int res = 0;
        for (int i=0; i<points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int sameX = 1;
            int samePos = 0;
            for (int j=i+1; j<points.length; j++) {
                if (points[j].x==points[i].x) {
                    if (points[j].y==points[i].y) {
                        samePos++;
                    }
                    sameX++;
                    continue;
                }
                // prevent decimal precision loss
                int dy = points[j].y - points[i].y;
                int dx = points[j].x - points[i].x;
                int gcd = gcd(dy, dx);
                dy /= gcd;
                dx /= gcd;
                String fraction = dy + "/" + dx;
                map.put(fraction, map.getOrDefault(fraction, 1)+1);
                res = Math.max(res, map.get(fraction)+samePos);
            }
            res = Math.max(res, sameX);
        }
        return res;
    }
    // Euclidean Algorithm for Greatest Common Divisor
    private int gcd(int a, int b) {
        return a==0 ? b : gcd(b%a, a);
    }
}