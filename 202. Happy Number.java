class Solution {
    public boolean isHappy(int n) {
        Set<Integer> save = new HashSet<Integer>(); // set<Integer> save = new HashSet<Integer>(); save.add(), save.contains save.remove
        int nextNum = 0;
        int digit = 0;
        while(!save.contains(nextNum)){
            System.out.println(nextNum);
            save.add(n);
            nextNum = 0;
            while(n!=0){
                digit = n%10;
                nextNum += digit*digit;
                n = n/10;
            }
            n = nextNum;
            if(nextNum==1) return true;
        }
        return false;
    }
}