// t:n s:1
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n==0) return true;
        int count = 0;
        for (int i=0; i<flowerbed.length; i++) {
            if (canPlant(i, flowerbed)) {
                flowerbed[i] = 1;
                count++;
                if (count==n) return true;
            }
        }
        return false;
    }
    private boolean canPlant(int i, int[] flowerbed) {
        if (flowerbed[i]==1) return false;
        return (i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1 || flowerbed[i+1]==0);
    }
}