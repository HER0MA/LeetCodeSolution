class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new LinkedList<Integer>();
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)=='+' || input.charAt(i)=='-' || input.charAt(i)=='*'){
                String part1 = input.substring(0,i); // first contain, second not contain
                String part2 = input.substring(i+1);
                List<Integer> part1List = diffWaysToCompute(part1);
                List<Integer> part2List = diffWaysToCompute(part2);
                int tempSave = 0;
                for(int p1 : part1List){
                    for(int p2 : part2List){
                        switch(input.charAt(i)){
                            case '+':
                                tempSave = p1 + p2;
                                break;
                            case '-':
                                tempSave = p1 - p2;
                                break;
                            case '*':
                                tempSave = p1 * p2;
                                break;
                            default:;
                        }
                        ans.add(tempSave);
                    }
                }
            }
        }
        if(ans.size()==0)
        	ans.add(Integer.valueOf(input));// convert the whole string to int
            //ans.add(input.charAt(0)-'0');
        return ans;
    }
}

public class Solution{
	public List<Integer> diffWaysToCompute(String input){
		List<Integer> ret = new Linkedlist<Integer>();
		for(int i=0; i<input.length(); i++){
			if(input.charAt(i)=='-' || input.charAt(i)=='+' || input.charAt(i)=='*'){
				String part1 = input.substring(0,i);
				String part2 = input.substring(i+1);
				List<Integer> part1Ret = diffWaysToCompute(part1);
				List<Integer> part2Ret = diffWaysToCompute(part2);
				for(Integer p1 : part1Ret){
					for(Integer p2 : part2Ret){
						int result = 0;
						switch(input.charAt(i)){
							case '+': result = p1 + p2;
							break;
							case '-': result = p1 - p2;
							break;
							case '*': result = p1 * p2;
							break;
						}
						ret.add(result);
					}
				}
			}
		}
		if(ret.size()==0){
			ret.add(Integer.valueOf(input));
		}
		return ret;
	}
}