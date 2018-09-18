/**
 * interface that allows for creating nested lists.
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
// version 1
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList==null) return 0;
        int res = 0;
        int depth = 1;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextList = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    res += ni.getInteger() * depth;
                } else {
                    nextList.addAll(ni.getList());
                }
            }
            depth++;
            nestedList = nextList;
        }
        return res;
    }
}
// version 2
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int res = 0;
        for (NestedInteger ni : nestedList) {
            res += helper(ni, 1);
        }
        return res;
    }
    private int helper(NestedInteger ni, int depth) {
        if (ni.isInteger()) return ni.getInteger()*depth;
        int res = 0;
        for (NestedInteger niSub : ni.getList()) {
            res += helper(niSub, depth+1);
        }
        return res;
    }
}
// version 3
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        return helper(nestedList, 1);
    }

    public int helper(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                res += nest.getInteger() * depth;
            } else {
                res += helper(nest.getList(), depth + 1);
            }
        }
        return res;
    }