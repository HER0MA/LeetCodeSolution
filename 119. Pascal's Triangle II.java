class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curr = new LinkedList<Integer>();
        if(rowIndex==0){
            curr.add(1);
            return curr;
        }
        List<Integer> prev = new LinkedList<Integer>();
        prev.add(1);
        prev.add(1);
        if(rowIndex==1) return prev;
        int count = 2;
        int temp = 0;
        while(count<=rowIndex){
            curr = new LinkedList<Integer>();
            curr.add(1);
            for(int i=1; i<prev.size(); i++){
                temp = prev.get(i-1) + prev.get(i);
                curr.add(temp);
            }
            curr.add(1);
            prev = curr;
            count++;
        }
        return curr;
    }
}