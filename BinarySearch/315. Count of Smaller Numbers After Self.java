// t:n^2 s:n
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i=nums.length-1; i>=0; i--) {
            int insertPos = binarySearch(nums[i], list);
            res[i] = insertPos;
            list.add(insertPos, nums[i]);
        }
        List<Integer> resList = new ArrayList<>();
        for (int i=0; i<res.length; i++) {
            resList.add(res[i]);
        }
        return resList;
    }
    // binary search return the index to insert
    private int binarySearch(int target, List<Integer> list) {
        if (list.size()==0) return 0;
        if (list.get(0)>=target) return 0;
        int start = 0;
        int end = list.size()-1;
        if (list.get(end)<target) return end+1;
        while (start+1<end) {
            int mid = start + (end-start)/2;
            if (list.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        // list[start] < target
        // list[end] >= target
        return end;
    }
}
// t: nlogn s:n
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        // pair[0] = val, pair[1] = index
        List<Integer> res = new ArrayList();
        int n = nums.length;
        if (n == 0) return res;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < nums.length; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
            res.add(0);
        }
        mergeCount(0, pairs.length - 1, pairs, res);
        return res;
    }
    
    private void mergeCount(int left, int right, int[][] pairs, List<Integer> res) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeCount(left, mid, pairs, res);
        mergeCount(mid + 1, right, pairs, res);
        int i = left;
        int j = mid + 1;
        while (i <= mid) {
            while (j <= right && pairs[j][0] < pairs[i][0]) {
                j++;
            }
            int count = res.get(pairs[i][1]) + j - mid - 1; // j - 1 - (mid + 1) - 1
            res.set(pairs[i][1], count);
            i++;
        }
        merge(left, mid, right, pairs);
    }
    
    private void merge(int left, int mid, int right, int[][] pairs) {
        int[][] temp = new int[right - left + 1][2];
        int idx1 = left;
        int idx2 = mid + 1;
        int idx = 0;
        while (idx1 <= mid && idx2 <= right) {
            if (pairs[idx1][0] < pairs[idx2][0]) {
                temp[idx][0] = pairs[idx1][0];
                temp[idx++][1] = pairs[idx1++][1];
            } else {
                temp[idx][0] = pairs[idx2][0];
                temp[idx++][1] = pairs[idx2++][1];
            }
        }
        while (idx1 <= mid) {
            temp[idx][0] = pairs[idx1][0];
            temp[idx++][1] = pairs[idx1++][1];
        }
        while (idx2 <= right) {
            temp[idx][0] = pairs[idx2][0];
            temp[idx++][1] = pairs[idx2++][1];
        }
        for (int i = 0; i < temp.length; i++) {
            pairs[left + i][0] = temp[i][0];
            pairs[left + i][1] = temp[i][1];
        }
    }
}