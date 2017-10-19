class Solution {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for(int i=0; 2*i*k<c.length; i++){
            int m = 2*i*k;x
            int n = c.length - 2*k*i>=k ? m + k-1 : c.length-1 ;
            while(m<n){
                    char temp = c[m];
                    c[m++] = c[n];
                    c[n--] = temp;
            }
        }
        return new String(c);
    }
}