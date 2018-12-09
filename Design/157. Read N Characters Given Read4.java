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

public class Solution extends Reader4 {
    public int read(char[] buf, int n) {
        int count = 0;
        char[] store = new char[4];
        int readIdx = 0;
        int numInStore = 0;
        while (count<n) {
            if (readIdx==numInStore) {
                numInStore = read4(store);
                readIdx = 0;
            }
            if (numInStore==0) return count;
            buf[count++] = store[readIdx++];
        }
        return count;
    }
}