class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()<=1) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int leftMost = -1;
        int max = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') stack.push(i);
            else{//')'
                if(!stack.isEmpty()){
                    stack.pop();
                    if(!stack.isEmpty()){
                        max = i-stack.peek()>max ? i-stack.peek() : max;
                    }else{
                        max = i-leftMost>max ? i-leftMost : max;
                    }
                }else{//stack is empty
                    leftMost = i;
                }
            }
        }
        return max;
    }
}
/*
stack + leftMost 
*/