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
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList==null) return 0;
        int currSum = 0;
        int res = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextList = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    currSum += ni.getInteger();
                } else {
                    nextList.addAll(ni.getList());
                }
            }
            res += currSum;
            nestedList = nextList;
        }
        return res;
    }
}

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        return helper(nestedList, 0);
    }

    private int helper(List<NestedInteger> nestedList, int res) {
        List<NestedInteger> nextList = new LinkedList<>();
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                res += nest.getInteger();
            } else {
                nextList.addAll(nest.getList());
            }
        }
        res += nextList.isEmpty() ? 0 : helper(nextList, res);
        return res;
    }
}