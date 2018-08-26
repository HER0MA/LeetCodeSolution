// t:n s:1
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas==null || gas.length==0 || cost.length!=gas.length) return -1;
        int start = 0;
        int remain = 0;
        int debt = 0;
        for (int i=0; i<gas.length; i++) {
            remain += gas[i] - cost[i];
            if (remain<0) {
                debt += remain;
                remain = 0;
                start = i+1;
            }
        }
        return remain + debt >=0 ? start : -1;
    }
}