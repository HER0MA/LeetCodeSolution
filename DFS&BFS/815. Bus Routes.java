// t:#(stops) s:#(stops)
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                if (!map.containsKey(stop)) {
                    map.put(stop, new ArrayList<>());
                }
                map.get(stop).add(i);
            }
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int currStop = queue.poll();
                for (int bus : map.get(currStop)) {
                    if (!visited.contains(bus)) {
                        visited.add(bus);
                        for (int nextStop : routes[bus]) {
                            if (nextStop == T) return level;
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}