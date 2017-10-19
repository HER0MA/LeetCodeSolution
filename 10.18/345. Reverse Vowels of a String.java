class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int i= 0;
        int j = c.length-1;
        while(i<j){
            while(!"aeiouAEIOU".contains(""+c[i]) && i<c.length-1) i++;
            while(!"aeiouAEIOU".contains(""+c[j]) && j>0) j--;
            if(i<j){
                char temp = c[i];
                c[i++] = c[j];
                c[j--] = temp;
            }
        }
        return new String(c);
    }
}