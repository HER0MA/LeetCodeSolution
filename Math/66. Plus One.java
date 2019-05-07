// t:n s:n
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return new int[]{1};
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            if (carry == 0) break;
            digits[i] %= 10;
        }
        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}