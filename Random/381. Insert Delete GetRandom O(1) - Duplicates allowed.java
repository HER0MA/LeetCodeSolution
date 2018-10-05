class RandomizedCollection {
    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. 
     *  Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) map.put(val, new HashSet<>());
        map.get(val).add(list.size());
        list.add(val);
        return !contain;
    }
    
    /** Removes a value from the collection. 
     *  Returns true if the collection contained the specified element. 
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        Set<Integer> indexes = map.get(val);
        int index = indexes.iterator().next();
        indexes.remove(index);
        if (indexes.isEmpty()) map.remove(val);
        int lastVal = list.remove(list.size()-1);
        // after remove last number in list
        // list.size() is index of lastVal
        if (index!=list.size()) {
            // replace the number to delete with last value
            list.set(index, lastVal);
            // update index of last value in map
            map.get(lastVal).remove(list.size());
            map.get(lastVal).add(index);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */