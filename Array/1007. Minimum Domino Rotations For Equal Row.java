// t:n s:1
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if (A.length == 0) return 0;
        int res = Math.min(helper(A[0], A, B), helper(B[0], A, B));
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private int helper(int target, int[] A, int[] B) {
        int lenA = 0;
        int lenB = 0;
        int lenAB = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target && B[i] == target) {
                lenAB++;
            } else if (A[i] == target) {
                lenA++;
            } else if (B[i] == target) {
                lenB++;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return Math.min(lenA, lenB);
    }
}
// t:n^2 s:1
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (!set.contains(A[i])) {
                int num = numSwap(A[i], A, B);
                if (num != -1) {
                    res = Math.min(res, num);
                }
                set.add(A[i]);
            }
        }
        set = new HashSet<>();
        for (int i = 0; i < B.length; i++) {
            if (!set.contains(B[i])) {
                int num = numSwap(B[i], B, A);
                if (num != -1) {
                    res = Math.min(res, num);
                }
                set.add(B[i]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private int numSwap(int target, int[] n1, int[] n2) {
        int count = 0;
        for (int i = 0; i < n1.length; i++) {
            if (n1[i] == target) {
                continue;
            } else if (n2[i] == target) {
                count++;
            } else {
                return -1;
            }
        }
        return count;
    }
}