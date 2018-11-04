class Solution {
    private static String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
                                              "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final int BILLION  = 1000000000;
    private static final int MILLION  = 1000000;
    private static final int THOUSAND = 1000;
    private static final int HUNDRED  = 100;
    
    public String numberToWords(int num) {
        if (num==0) return "Zero";
        StringBuilder sb = new StringBuilder();
        if (num / BILLION != 0) {
            sb.append(helper(num / BILLION));
            sb.append(" Billion ");
        }
        num %= BILLION;
        if (num / MILLION != 0) {
            sb.append(helper(num / MILLION));
            sb.append(" Million ");
        }
        num %= MILLION;
        if (num / THOUSAND != 0) {
            sb.append(helper(num / THOUSAND));
            sb.append(" Thousand ");
        }
        sb.append(helper(num % THOUSAND));
        return sb.toString().trim();
    }
    private String helper(int num) {
        StringBuilder sb = new StringBuilder();
        if (num / HUNDRED != 0) {
            sb.append(lessThan20[num / HUNDRED]);
            sb.append(" Hundred ");
        }
        num %= HUNDRED;
        if (num >= 20) {
            sb.append(tens[num / 10]);
            sb.append(" ");
            sb.append(lessThan20[num % 10]);
        } else {
            sb.append(lessThan20[num]);
        }
        return sb.toString().trim();
    }
}