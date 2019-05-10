// t:#(queries)*(V+E) s:V
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
            if (!map.containsKey(var1)) {
                map.put(var1, new HashMap<>());
            }
            map.get(var1).put(var2, values[i]);
            if (!map.containsKey(var2)) {
                map.put(var2, new HashMap<>());
            }
            map.get(var2).put(var1, 1 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            res[i] = find(start, end, 1.0, new HashSet<>(), map);
        }
        return res;
    }
    
    private double find(String start, String end, double val, Set<String> visited, Map<String, Map<String, Double>> map) {
        if (!map.containsKey(start) || visited.contains(start)) return -1.0;
        if (start.equals(end)) return val;
        visited.add(start);
        Map<String, Double> nextMap = map.get(start);
        for (Map.Entry<String, Double> entry : nextMap.entrySet()) {
            double res = find(entry.getKey(), end, val * entry.getValue(), visited, map);
            if (res != -1.0) return res;
        }
        visited.remove(start);
        return -1.0;
    }
}