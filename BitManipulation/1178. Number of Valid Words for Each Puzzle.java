// t:words.length * max(wordLen) + puzzles.length (* 2^7)
// s:words.length
class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int mask = 0;
            for (int j = 0; j < words[i].length(); j++) {
                mask |= 1 << (words[i].charAt(j) - 'a');
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            int mask = 0;
            for (int j = 0; j < puzzles[i].length(); j++) {
                mask |= 1 << (puzzles[i].charAt(j) - 'a');
            }
            int sub = mask;
            int first = 1 << (puzzles[i].charAt(0) - 'a');
            int count = 0;
            while (sub != 0) {
                if ((first & sub) == first) {
                    count += map.getOrDefault(sub, 0);
                }
                sub = (sub - 1) & mask; // get all combinations with letters in puzzles[i]
            }
            res.add(count);
        }
        return res;
    }
}