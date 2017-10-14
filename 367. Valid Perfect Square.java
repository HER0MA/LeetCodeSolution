class Solution {
    public static boolean isPerfectSquare(int num) {
        if(num<=1) return true;
        int i=1;
        while(i*i<num) {
            i=2*i;
            
            if(i<0){
                i = 2147483646;
                break;
            }
        }
        int max = i;
        while(!(i<=num/i && (i+1)>num/(i+1))){
            if((i+1)<=num/(i+1)) i=i+max/2+1;
            else if(i>num/i) i=i-max/2-1;
            max = max/2;
        }
        return i*i==num;
    }
}

//overflow question