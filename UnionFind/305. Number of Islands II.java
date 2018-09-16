// t:points^2 s:m*n
class Solution {
    private static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m<1 || n<1) return res;
        int count = 0;
        // transform two dimensions into one dimension
        int[] roots = new int[m*n];
        // -1 mean this position is water
        Arrays.fill(roots, -1);
        for (int[] pos : positions) {
            int loc = pos[0]*n+pos[1];
            // max means this land does not have superior root
            roots[loc] = Integer.MAX_VALUE;
            count ++;
            
            for (int[] dir : directions) {
                int x = pos[0]+dir[0];
                int y = pos[1]+dir[1];
                int adjLoc = x*n+y;
                // beyond the boundary or no land
                if (x<0 || x>=m || y<0 || y>=n || roots[adjLoc]==-1) continue;
                int adjLocRoot = find(adjLoc, roots);
                int locRoot = find(loc, roots);
                // special case: loc connects two or more islands
                if (adjLocRoot!=locRoot) {
                    roots[locRoot] = adjLocRoot;
                    count --;
                }
            }
            res.add(count);
        }
        return res;
    }
    private int find(int loc, int[] roots) {
        while (roots[loc]!=Integer.MAX_VALUE) {
            loc = roots[loc];
        }
        return loc;
    }
}