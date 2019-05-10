// t:nlogn s:n
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String start = ticket.get(0);
            String end = ticket.get(1);
            if (!map.containsKey(start)) {
                map.put(start, new PriorityQueue<String>());
            }
            map.get(start).offer(end);
        }
        dfs("JFK", map, res);
        return res;
    }
    
    private void dfs(String curr, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {
        while (map.containsKey(curr) && !map.get(curr).isEmpty()) {
            dfs(map.get(curr).poll(), map, res);
        }
        // a node do not have outgoing edges, it can not be visited again
        res.add(0, curr);
    }
}