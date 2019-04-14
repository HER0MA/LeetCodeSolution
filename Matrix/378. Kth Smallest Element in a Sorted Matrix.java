// t:nlogn s:n
// priorityQueue and linkedList
class Solution {
    // when poll out the value, I can get the row and column number
    class Tuple{
        int x;
        int y;
        int val;
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int j = 0; j < matrix.length; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        // poll out samllest k-1 elements
        for (int t = 0; t < k - 1; t++) {
            Tuple tuple = pq.poll();
            if (tuple.x == matrix.length - 1) continue;
            pq.offer(new Tuple(tuple.x + 1, tuple.y, matrix[tuple.x + 1][tuple.y]));
        }
        return pq.poll().val;
    }
}

// t:n*log(max-min) s:1
// binary search and count
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int start = matrix[0][0];
        int end = matrix[matrix.length - 1][matrix.length - 1];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int count = countSmaller(matrix, mid);
            if (count >= k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        // if the larger one can satisfy, larger one is the result
        if (countSmaller(matrix, end) <= k - 1) return end;
        return start;
    }
    // get #(elements smaller than num)
    private int countSmaller(int[][] matrix, int num) {
        int res = 0;
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix.length) {
            if (matrix[i][j] < num) {
                res += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return res;
    }
}