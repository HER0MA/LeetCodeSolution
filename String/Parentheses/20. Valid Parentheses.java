// t:n s:n
class Solution {
    public boolean isValid(String s) {
        if (s.length()%2==1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || 
                       s.charAt(i)==')' && stack.pop()!='(' ||
                       s.charAt(i)==']' && stack.pop()!='[' ||
                       s.charAt(i)=='}' && stack.pop()!='{') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}