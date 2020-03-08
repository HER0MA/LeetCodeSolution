// t:n s:n
class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int[][] dis = new int[colors.length][4];
        int[] lastIdx = new int[4];
        lastIdx[1] = lastIdx[2] = lastIdx[3] = Integer.MAX_VALUE;
        for (int i = 0; i < colors.length; i++) {
            dis[i][1] = dis[i][2] = dis[i][3] = Integer.MAX_VALUE;
            lastIdx[colors[i]] = i;
            for (int j = 1; j <=3; j++) {
                if (lastIdx[j] != Integer.MAX_VALUE) {
                    dis[i][j] = i - lastIdx[j];
                }
            }
        }
        lastIdx[1] = lastIdx[2] = lastIdx[3] = Integer.MAX_VALUE;
        for (int i = colors.length - 1; i >= 0; i--) {
            lastIdx[colors[i]] = i;
            for (int j = 1; j <= 3; j++) {
                if (lastIdx[j] != Integer.MAX_VALUE) {
                    dis[i][j] = Math.min(dis[i][j], lastIdx[j] - i);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            res.add(dis[queries[i][0]][queries[i][1]] == Integer.MAX_VALUE ? -1 : dis[queries[i][0]][queries[i][1]]);
        }
        return res;
    }
}