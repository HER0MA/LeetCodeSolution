// quickSort
// t:nlogn s:1
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivot = left++;
        while (left <= right) {
            while (left <= right && nums[left] <= nums[pivot]) left++;
            while (left <= right && nums[right] >= nums[pivot]) right--;
            if (left <= right) {
                swap(nums, left++, right--);
            }
        }
        // nums[left] > nums[pivot]
        // nums[right] < nums[pivot]
        // swap right and pivot
        swap(nums, pivot, right);
        return right;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// mergeSort
// t:logn s:n
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    
    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int idx1 = left;
        int idx2 = mid + 1;
        int idx = 0;
        while (idx1 <= mid && idx2 <= right) {
            if (nums[idx1] < nums[idx2]) {
                temp[idx++] = nums[idx1++];
            } else {
                temp[idx++] = nums[idx2++];
            }
        }
        while (idx1 <= mid) {
            temp[idx++] = nums[idx1++];
        }
        while (idx2 <= right) {
            temp[idx++] = nums[idx2++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }
}