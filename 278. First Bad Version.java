/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int checkPoint = n;
        int var = n/2;
        while(true){
            if(isBadVersion(checkPoint)){
                if(!(isBadVersion(checkPoint-1))) return checkPoint;
                else{
                    checkPoint -= var;
                    if(var>1){
                        var /= 2;   
                    }else{
                        var = 1;
                    }
                }
            }else{
                if(isBadVersion(checkPoint+1)) return checkPoint+1;
                else{
                    checkPoint+= var;
                     if(var>1){
                        var /= 2;   
                    }else{
                        var = 1;
                    }
                }
            }
        }
    }
}