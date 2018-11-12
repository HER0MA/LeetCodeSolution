// t:n s:1
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        while (index<bits.length-1) {
            index += bits[index]==1 ? 2 : 1;
        }
        return index==bits.length-1;
    }
}