class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (numRows==0) return ans;
        List<Integer> prev = new LinkedList<Integer>();
        List<Integer> curr = null;
        prev.add(1);
        ans.add(prev);
        if(numRows==1) return ans;
        prev = new LinkedList<Integer>();
        prev.add(1);
        prev.add(1);
        ans.add(prev);
        if(numRows==2) return ans;
        int count=2;
        int temp = 0;
        while(count<numRows){
            curr = new LinkedList<Integer>();
            curr.add(1);
            temp = 1;
            for(int i=1; i< prev.size(); i++){
                temp = prev.get(i-1) + prev.get(i);
                curr.add(temp);
            }
            curr.add(1);
            ans.add(curr);
            prev = curr;
            count++;
        }
        return ans;
    }
}