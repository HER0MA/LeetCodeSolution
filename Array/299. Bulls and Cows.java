// t:n s:1
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] number = new int[10];
        for (int i=0; i<secret.length(); i++) {
            if (secret.charAt(i)==guess.charAt(i)) {
                bulls++;
                continue;
            }
            if (number[secret.charAt(i)-'0']++<0) {
                cows++;
            }
            if (number[guess.charAt(i)-'0']-->0) {
                cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}