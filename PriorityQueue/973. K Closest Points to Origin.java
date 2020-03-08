//t:nlogn s:n
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        for (int[] point : points) {
            pq.offer(point);
        }
        for (int i = 0; i < k; i++) {
            int[] point = pq.poll();
            res[i][0] = point[0];
            res[i][1] = point[1];
        }
        return res;
    }
}