// t:n s:n
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int start = 0;
        while (start < words.length) {
            int len = words[start].length();
            int end = start + 1;
            while (end < words.length) {
                if (len + words[end].length() + 1 > maxWidth) break;
                len += words[end].length() + 1;
                end++;
            }
            int spaceCount = end - start - 1;
            // last line
            int spaceLen = 1;
            int longerSpaceCount = 0;
            if (end != words.length) {
                // not last line 
                spaceLen = spaceCount == 0 ? 0 : (maxWidth - len) / spaceCount + 1;
                // len contains one space between two words
                longerSpaceCount = maxWidth - len - spaceCount * (spaceLen - 1);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[start]);
            for (int i = start + 1; i < end; i++) {
                for (int j = 0; j < spaceLen; j++) sb.append(' ');
                if (longerSpaceCount-- >0) sb.append(' ');
                sb.append(words[i]);
            }
            while (sb.length() < maxWidth) sb.append(' ');
            res.add(sb.toString());
            start = end;
        }
        return res;
    }
}