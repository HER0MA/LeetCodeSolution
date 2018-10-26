/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] storage = new char[4];
        int res = 0;
        int index = 0;
        while (true) {
            int count = read4(storage);
            for (int i=0; i<count && index<n; i++) {
                buf[index++] = storage[i];
            }
            if (index==n || count<4) return index;
        }
    }
}