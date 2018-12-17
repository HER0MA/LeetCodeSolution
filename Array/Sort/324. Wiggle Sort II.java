// t:nlogn s:n
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int mid = (n-1)/2;
        Arrays.sort(nums);
        // descending order 4 5 5 6
        // put numbers in first half array into odd index
        // put numbers in second half array into even index
        for (int i=0, j=0; i<=mid; i++, j+=2) {
            temp[j] = nums[mid-i];
            if (j+1<n) {
                temp[j+1] = nums[n-1-i];
            }
        }
        for (int i=0; i<n; i++) {
            nums[i] = temp[i];
        }
    }
}
// t:nlogn s:n
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] temp = nums.clone();
        int mid = (nums.length-1)/2;
        int i = mid;
        int j = temp.length-1;
        int index = 0;
        while (index < nums.length) {
            nums[index++] = temp[i--];
            if (index < nums.length) {
                nums[index++] = temp[j--];
            }
        }
    }
}

