class Solution {
    public boolean canWinNim(int n) {
        return n%4!=0;
        // Set<Integer> set = new HashSet<Integer>();
        // if(n<=3) return true;
        // set.add(1);
        // set.add(2);
        // set.add(3);
        // for(int i=4; i<=n; i++){
        //     if(!set.contains(i-1) || !set.contains(i-2) || !set.contains(i-3)) set.add(i);// make opponent loss
        // }
        // return set.contains(n);
    }
}