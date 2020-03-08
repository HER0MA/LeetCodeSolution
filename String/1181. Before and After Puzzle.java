class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<String, Set<String>> head = new HashMap();
        Map<String, Set<String>> tail = new HashMap();
        Map<String, Integer> count = new HashMap();
        for (String phrase : phrases) {
            String[] words = phrase.split(" ");
            head.computeIfAbsent(words[0], s -> new HashSet<>()).add(phrase);
            tail.computeIfAbsent(words[words.length - 1], s -> new HashSet<>()).add(phrase);
            count.put(phrase, 1 + count.getOrDefault(phrase, 0));
        }
        TreeSet<String> res = new TreeSet<>();
        for (String connectWord : head.keySet()) {
            if (tail.containsKey(connectWord)) {
                for (String s1 : tail.get(connectWord)) {
                    for (String s2 : head.get(connectWord)) {
                        if (!s1.equals(s2) || count.get(s1) > 1) {
                            res.add(s1 + s2.substring(connectWord.length()));
                        }
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}

class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        TreeSet<String> res = new TreeSet();
        for (int i = 1; i < phrases.length; i++) {
            for (int j = 0; j < i; j++) {
                String[] words1 = phrases[i].split(" ");
                String[] words2 = phrases[j].split(" ");
                if (words1[0].equals(words2[words2.length - 1])) {
                    res.add(phrases[j] + phrases[i].substring(words1[0].length()));
                }
                if (words2[0].equals(words1[words1.length - 1])) {
                    res.add(phrases[i] + phrases[j].substring(words2[0].length()));
                }
            }
        }
        return new ArrayList<String>(res);
    }
}