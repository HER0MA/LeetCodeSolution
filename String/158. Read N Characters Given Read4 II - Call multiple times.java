/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int count = 0;
    private int pointer = 0;
    private char[] storage = new char[4];
    
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            // pointer==0 means all chars in storage have been used
            if (pointer==0) {
                count = read4(storage);
            }
            if (count==0) break;
            while (pointer<count && index<n) {
                buf[index++] = storage[pointer++];
            }
            if (pointer==count) pointer=0;
        }
        return index;
    }
}