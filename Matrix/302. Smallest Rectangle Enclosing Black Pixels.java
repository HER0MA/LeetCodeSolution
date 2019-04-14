// t:mlogn+nlogm s:1
class Solution {
    public int minArea(char[][] image, int x, int y) {
        int left = binarySearch(0, y, false, true, image);
        int right = binarySearch(y, image[0].length - 1, false, false, image);
        int up = binarySearch(0, x, true, true, image);
        int down = binarySearch(x, image.length - 1, true, false, image);
        return (right - left + 1) * (down - up + 1);
    }
    
    private int binarySearch(int start, int end, boolean vertical, boolean smaller, char[][] image) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // when binary search vertically
            // search horizontally to find black
            // vice versa
            if (hasBlack(mid, vertical, image)) {
                if (smaller) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (smaller) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (smaller) {
            if (hasBlack(start, vertical, image)) return start;
            return end;
        }
        if (hasBlack(end, vertical, image)) return end;
        return start;
    }
    
    private boolean hasBlack(int index, boolean horizontal, char[][] image) {
        if (horizontal) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[index][j] == '1') {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < image.length; i++) {
                if (image[i][index] == '1') {
                    return true;
                }
            }
        }
        return false;
    }
}