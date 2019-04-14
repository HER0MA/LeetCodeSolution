// t:m*n s:#(points)
// for one dimension
// min distance = (max - min) + (2ndMax - 2ndMin) + ...
class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    y.add(i);
                }
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    x.add(j);
                }
            }
        }
        int start = 0;
        int end = x.size() - 1;
        int res = 0;
        while (start < end) {
            res += x.get(end) - x.get(start);
            res += y.get(end--) - y.get(start++);
        }
        return res;
    }
}