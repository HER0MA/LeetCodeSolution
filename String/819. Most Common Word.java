// t:n s:n
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.replaceAll("[,.;?!']", " ").toLowerCase().split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String word : banned) {
            map.put(word, -1);
        }
        int max = 0;
        String res = "";
        for (String word : words) {
            int count = map.getOrDefault(word, 0);
            if (count == -1) continue;
            count++;
            if (count > max) {
                max = count;
                res = word;
            }
            map.put(word, count);
        }
        return res;
    }
}