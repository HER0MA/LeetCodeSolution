// t:n s:n
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        while (i1 >= 0 || i2 >= 0) {
            int sum = carry;
            if (i1 >= 0) sum += num1.charAt(i1--) - '0';
            if (i2 >= 0) sum += num2.charAt(i2--) - '0';
            carry = sum / 10;
            sum %= 10;
            sb.append(sum);
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}