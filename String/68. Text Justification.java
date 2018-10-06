// t:n s:n
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int start = 0;
        while (start<words.length) {
            int end = start + 1;
            int count = words[start].length();
            while (end<words.length) {
                if (count+1+words[end].length()>maxWidth) break;
                count += words[end].length()+1;
                end++;
            }
            // number of seperators between words
            int seperator = end-start-1;
            StringBuilder sb = new StringBuilder();
            sb.append(words[start]);
            // last line or single word
            if (end==words.length || seperator==0) {
                for (int i=start+1; i<end; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                while (sb.length()!=maxWidth) {
                    sb.append(" ");
                }
            } else {
                // least number of spaces for each seperators
                int space = (maxWidth-count+seperator) / seperator;
                // number of seperators with one more space
                int remainder = (maxWidth-count) % seperator;
                for (int i=start+1; i<end; i++) {
                    for (int j=0; j<space; j++) {
                        sb.append(" ");
                    }
                    if (remainder>0) {
                        sb.append(" ");
                        remainder--;
                    }
                    sb.append(words[i]);
                }
            }
            res.add(sb.toString());
            start = end;
        }
        return res;
    }
}