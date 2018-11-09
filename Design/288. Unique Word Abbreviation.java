class ValidWordAbbr {
    Map<String, String> map;
    // t:n
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String word : dictionary) {
            String abbr = abbreviate(word);
            if (map.containsKey(abbr)) {
                if (!map.get(abbr).equals(word)) {
                    map.put(abbr, "");
                }
                
            } else {
                map.put(abbr, word);
            }
        }
    }
    // t:1
    public boolean isUnique(String word) {
        String abbr = abbreviate(word);
        return !map.containsKey(abbr) || map.get(abbr).equals(word);
    }
    // t:1
    private String abbreviate(String word) {
        return word.length()<3 ? word : word.charAt(0) + String.valueOf(word.length()-2) + word.charAt(word.length()-1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */