/* I 1      V 5
 * X 10     L 50
 * C 100    D 500
 * M 1000
 */
class Solution {
    private static String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static String[] M = {"", "M", "MM", "MMM"};
    
    public String intToRoman(int num) {
        return M[num/1000] + C[num%1000/100] + X[num%100/10] + I[num%10];
    }
}