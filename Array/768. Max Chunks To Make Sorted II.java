// t:n s:n
// Can seperate when current max <= back min
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] backMin = new int[n];
        backMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            backMin[i] = Math.min(backMin[i + 1], arr[i]);
        }
        int max = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(arr[i], max);
            if (max <= backMin[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
// t:nlogn s:n
// Sort and compare sum
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);
        int sum1 = 0;
        int sum2 = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i];
            sum2 += sorted[i];
            if (sum1 == sum2) {
                count++;
                sum1 = 0;
                sum2 = 0;
            }
        }
        return count;
    }
}