// t:mn s:m+n
class Solution {
    public String multiply(String num1, String num2) {
        int[] digits = new int[num1.length() + num2.length()];
        // must compute from lower digit to high digit
        // else miss carry
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + digits[i + j + 1];
                // must get sum first, else may miss carry
                digits[i + j + 1] = sum % 10;
                digits[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < digits.length && digits[idx] == 0) {
            idx++;
        }
        while (idx < digits.length) {
            sb.append(digits[idx++]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

class Solution {
    public String multiply(String num1, String num2) {
        if (num2.length() > num1.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        String zeros = "";
        String res = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            String currRes = strMultiply(num1, num2.charAt(i) - '0') + zeros;
            res = strAdd(res, currRes);
            zeros += '0';
        }
        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') {
            i++;
        }
        return i == res.length() ? "0" : res.substring(i, res.length());
    }
    
    private String strMultiply(String num, int n) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num.length() - 1; i >=0; i--) {
            int product = (num.charAt(i) - '0') * n + carry;
            sb.append(product % 10);
            carry = product / 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    
    private String strAdd(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            if (i >= 0) sum += num1.charAt(i) - '0';
            if (j >= 0) sum += num2.charAt(j) - '0';
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}