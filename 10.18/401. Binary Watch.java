class Solution {
    public List<String> readBinaryWatch(int num) {
        int[] hour = {8,4,2,1};
        int[] minute = {32,16,8,4,2,1};
        List<String> ans = new LinkedList<String>();
        int maxHourDigits = num>4 ? 4:num;
        List<Integer> hours = null;new LinkedList<Integer>();
        List<Integer> minutes = null;new LinkedList<Integer>();
        String str = "";
        for(int i=0; i<=maxHourDigits; i++){
            hours = new LinkedList<Integer>();
            minutes = new LinkedList<Integer>();
            makeDigit(hour,i,0,0,hours);
            makeDigit(minute,num-i,0,0,minutes);
            for(int h:hours){
                if(h<12){
                    for(int m:minutes){
                        if(m<60){
                            str = ""+h+":";
                            if(m<10){
                                str+="0"+m;
                            }else{
                                str+=m;
                            }
                            ans.add(str);
                        }
                    }
                }
            }
        }
        //System.out.println(hours.size());
        //System.out.println(minutes.size());
        return ans;
    }
    private void makeDigit(int[] hour,int count,int index, int sum, List<Integer> hours){
        if(count == 0) hours.add(sum);
        for(int i=index; i<hour.length; i++){
            makeDigit(hour, count-1,i+1,sum+hour[i],hours);
        }
    }
}