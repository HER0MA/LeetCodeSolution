// t:n s:1
class Solution {
    public int compress(char[] chars) {
        int fast = 0;
        int slow = 0;
        while (fast < chars.length) {
            int count = 1;
            while (fast + 1 < chars.length  && chars[fast + 1] == chars[fast]) {
                count++;
                fast++;
            }
            chars[slow++] = chars[fast];
            if (count > 1) {
                int preSlow = slow;
                while (count != 0) {
                    chars[slow++] = (char)('0' + count % 10);
                    count /= 10;
                }
                reverse(chars, preSlow, slow - 1);
            }
            fast++;
        }
        return slow;
    }
    
    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;   
        }
    }
}