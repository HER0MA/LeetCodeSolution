// t:n^2 s:n
class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            if (!map.containsKey(point[0])) map.put(point[0], new HashSet<>());
            map.get(point[0]).add(point[1]);
        }
        int res = Integer.MAX_VALUE;
        for (int i=1; i<points.length; i++) {
            for (int j=0; j<i; j++) {
                if (points[i][0]==points[j][0] || points[i][1]==points[j][1]) continue;
                if (map.get(points[i][0]).contains(points[j][1]) && map.get(points[j][0]).contains(points[i][1])) {
                    res = Math.min(res, Math.abs((points[i][0]-points[j][0])*(points[i][1]-points[j][1])) );
                }
            }
        }
        return res==Integer.MAX_VALUE ? 0 : res ;
    }
}