class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int idx1 = s1.indexOf(' ') + 1;
                int idx2 = s2.indexOf(' ') + 1;
                if (Character.isDigit(s1.charAt(idx1))) {
                    if (Character.isDigit(s2.charAt(idx2))) return 0;
                    return 1;
                }
                if (Character.isDigit(s2.charAt(idx2))) return -1;
                int wordComp = s1.substring(idx1).compareTo(s2.substring(idx2));
                if (wordComp == 0) return s1.substring(0, idx1 - 1).compareTo(s2.substring(0, idx2 - 1));
                return wordComp;
            }
        };
        
        Arrays.sort(logs, comparator);
        return logs;
    }
}