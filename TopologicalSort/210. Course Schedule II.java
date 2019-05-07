// t:V+E s:V+E
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int idx = 0;
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : prerequisites) {
            inDegree[pair[0]]++;
            if (map.containsKey(pair[1])) {
                map.get(pair[1]).add(pair[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(pair[0]);
                map.put(pair[1], list);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res[idx++] = pre;
            List<Integer> list = map.get(pre);
            if (list != null) {
                for (int next : list) {
                    if (--inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return idx == numCourses ? res : new int[0];
    }
}