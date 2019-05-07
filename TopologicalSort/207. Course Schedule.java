// t:V+E s:V+E
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : prerequisites) {
            inDegree[pair[0]]++;
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new ArrayList<Integer>());
            }
            map.get(pair[1]).add(pair[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            count++;
            List<Integer> list = map.get(pre);
            if (list != null) {
                for (int next : list) {
                    if (--inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return count == numCourses;
    }
}