// t:n s:n
class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf('\t') + 1;
            while (stack.size() > level + 1) {
                stack.pop();
            }
            // s.length()-level is actual length
            // +1 for a '\'
            int len = stack.peek() + s.length() - level + 1;
            stack.push(len);
            if (s.contains(".")) {
                res = Math.max(res, len - 1);
            }
        }
        return res;
    }
}