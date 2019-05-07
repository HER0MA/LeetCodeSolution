// t:V+E s:V+E
class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, Integer> inDegree = new HashMap<>();
        HashMap<Character, List<Character>> order = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                inDegree.put(word.charAt(i), 0);
            }
        }
        for (int i = 1; i < words.length; i++) {
            generateDegree(words[i - 1], words[i], inDegree, order);
        }
        Queue<Character> queue = new LinkedList<>();
        for (char ch : inDegree.keySet()) {
            if (inDegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char pre = queue.poll();
            sb.append(pre);
            List<Character> list = order.get(pre);
            if (list != null) {
                for (char next : list) {
                    inDegree.put(next, inDegree.get(next) - 1);
                    if (inDegree.get(next) == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return sb.length() == inDegree.size() ? sb.toString() : "";
    }
    
    private void generateDegree(String s1, String s2, Map<Character, Integer> inDegree, Map<Character, List<Character>> order) {
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                inDegree.put(c2, inDegree.get(c2) + 1);
                if (!order.containsKey(c1)) {
                    order.put(c1, new ArrayList<Character>());
                }
                order.get(c1).add(c2);
                break;
            }
        }
    }
}