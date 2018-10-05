class RandomizedSet {
    // no duplicate
    // map stores number and its index in list
    // list for getRandom
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. 
     *  Returns true if the set did not already contain the specified element. 
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. 
     *  Returns true if the set contained the specified element. 
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.remove(val);
        // always remove the last value in list 
        int lastVal = list.remove(list.size()-1);
        // after remove last number in list
        // list.size() is index of lastVal
        if (index!=list.size()) {
            // replace the number to delete with last value
            list.set(index, lastVal);
            // update index of last value in map
            map.put(lastVal, index);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */