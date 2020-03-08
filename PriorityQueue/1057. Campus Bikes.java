// t:mnlog(mn) s:mn
class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        // [worker, bike, distance]
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) ->
            a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]
        );
        
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                pq.offer(new int[]{i, j, dist});
            }
        }
        boolean[] workerUsed = new boolean[workers.length];
        boolean[] bikeUsed = new boolean[bikes.length];
        int[] res = new int[workers.length];
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            if (!workerUsed[pair[0]] && !bikeUsed[pair[1]]) {
                res[pair[0]] = pair[1];
                workerUsed[pair[0]] = true;
                bikeUsed[pair[1]] = true;
            }
        }
        return res;
    }
}