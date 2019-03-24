/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// t:n s:n
// number: new NestedInteger(int)
// list: new NestedInteger()
class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger res = new NestedInteger();
        stack.push(res);
        int start = 1;
        for (int idx = 1; idx < s.length(); idx++) {
            char ch = s.charAt(idx);
            if (ch == '[') {
                NestedInteger ni = new NestedInteger();
                stack.peek().add(ni);
                stack.push(ni);
                start = idx + 1;
            } else if (ch == ',' || ch == ']') {
                // consecutive ']'
                if (idx > start) {
                    stack.peek().add(new NestedInteger(Integer.valueOf(s.substring(start, idx))));
                }
                start = idx + 1;
                if (ch == ']') {
                    stack.pop();
                }
            }
        }
        return res;
    }
}

class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger res = new NestedInteger();
        stack.push(res);
        int num = 0;
        for (int idx = 1; idx < s.length(); idx++) {
            if (Character.isDigit(s.charAt(idx))) {
                num = s.charAt(idx) - '0';
                int sign = s.charAt(idx - 1) == '-' ? -1 : 1;
                while (Character.isDigit(s.charAt(++idx))) {
                    num = num * 10 + s.charAt(idx) - '0';
                }
                num *= sign;
                idx--;
            } else if (s.charAt(idx) == '-') {
                continue;
            } else if (s.charAt(idx) == '[') {
                NestedInteger ni = new NestedInteger();
                stack.peek().add(ni);
                stack.push(ni);
            } else {
                if (Character.isDigit(s.charAt(idx -1))) {
                    stack.peek().add(new NestedInteger(num));
                }
                if (s.charAt(idx) == ']') {
                    stack.pop();
                }
            }
        }
        return res;
    }
}