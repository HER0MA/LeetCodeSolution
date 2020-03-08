// t:n s:n
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        for (int i = 0; i < s.length(); i++) {
            // unit size is 2 * numRows - 2
            // first and last do not exist in reverse order
            int index = i % (2 * numRows - 2);
            // numRows - 1 - (index - (numRows - 1))
            int row = index < numRows ? index : 2 * numRows - 2 - index;
            sb[row].append(s.charAt(i));
        }
        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}