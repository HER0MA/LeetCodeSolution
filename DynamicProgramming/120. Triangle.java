// t:n^2 s:n
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // triangle.size()+1, prevent index out of bounds
        int[] state = new int[triangle.size()+1];
        for (int i=triangle.size()-1; i>=0; i--) {
            for (int j=0; j<triangle.get(i).size(); j++) {
                state[j] = Math.min(state[j], state[j+1]) + triangle.get(i).get(j);
            }
        }
        return state[0];
    }
}