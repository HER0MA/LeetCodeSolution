class Solution {
    public boolean isPowerOfThree(int n) {
        String ternary = Integer.toString(n, 3);//Integer.toString(number, base);
        return ternary.matches("^10*$");//Regular Expression
    }
}