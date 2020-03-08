// Dijkstra Algorithm
// t:nlogn+e s:n+e
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Adjacnet matrix, O(e)
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        Map<Integer, Integer> dis = new HashMap();
        // n iteration each for one node, at most n entries in pq
        while (!pq.isEmpty()) {
            int[] minInfo = pq.poll();
            int minNode = minInfo[0];
            int minDis = minInfo[1];
            if (dis.containsKey(minNode)) continue;
            dis.put(minNode, minDis);
            if (graph.containsKey(minNode)) {
                for (int[] adjEdge : graph.get(minNode)) {
                    int adjNode = adjEdge[0];
                    int adjDis = adjEdge[1];
                    if (dis.containsKey(adjNode)) continue;
                    pq.offer(new int[]{adjNode, minDis + adjDis});
                }
            }
        }
        if (dis.size() != n) return -1; 
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dis.get(i));
        }
        return res;
    }
}
// t:n^2+e s:n+e
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Adjacent matrix, O(e)
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        // distance from k to each node, O(n)
        Map<Integer, Integer> dis = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            dis.put(i, Integer.MAX_VALUE);
        }
        dis.put(k, 0);
        boolean[] visited = new boolean[n + 1];
        while (true) { // at most n times
            // find node with minimum distance to k that has not be visited
            int minNode = -1;
            int minDis = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) { // O(n)
                if (!visited[i] && dis.get(i) < minDis) {
                    minNode = i;
                    minDis = dis.get(i);
                }
            }
            if (minNode == -1) break;
            visited[minNode] = true;
            // update distance from all adjacent node to the min-distance node
            if (graph.containsKey(minNode)) {
                for (int[] adjNode : graph.get(minNode)) {
                    dis.put(adjNode[0], Math.min(dis.get(adjNode[0]), dis.get(minNode) + adjNode[1]));
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dis.get(i));
            if (res == Integer.MAX_VALUE) return -1;
        }
        return res;
    }
}