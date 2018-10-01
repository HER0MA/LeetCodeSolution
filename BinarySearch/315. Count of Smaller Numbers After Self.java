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