// t:n s:n
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        // nums in sorted order
        for (int i=1; i<=n; i++) {
            nums.add(i);
        }
        // factorial
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i=1; i<n; i++) {
            fact[i] = fact[i-1] * i;
        }
        StringBuilder sb = new StringBuilder();
        k --;
        // fill from high to low
        // for each number, there are fact[i-1] permutations start with this number
        // so we choose the (k/fact[i-1])th number for this digit
        for (int i=n; i>0; i--) {
            int index = k/fact[i-1];
            sb.append(nums.get(index));
            nums.remove(index);
            k %= fact[i-1];
        }
        return sb.toString();
    }
}