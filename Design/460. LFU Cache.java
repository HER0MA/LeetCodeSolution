// s:n
class LFUCache {
    private Map<Integer, Integer> keyToVal;
    private Map<Integer, Integer> keyToFreq;
    private Map<Integer, LinkedHashSet<Integer>> freqToKey;
    private int minFreq;
    private int capacity;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKey = new HashMap<>();
        freqToKey.put(1, new LinkedHashSet<>());
        this.capacity = capacity;
        minFreq = 1;
    }
    // t:1
    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        // remove from old frequency
        freqToKey.get(freq).remove(key);
        if (freqToKey.get(minFreq).size() == 0) {
            minFreq++;
        }
        // add to new frequency
        if (!freqToKey.containsKey(freq + 1)) {
            freqToKey.put(freq + 1, new LinkedHashSet<>());
        }
        freqToKey.get(freq + 1).add(key);
        return keyToVal.get(key);
    }
    // t:1
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (get(key) != -1) {
            // frequency has been increased in get function
            keyToVal.put(key, value);
            return;
        }
        
        if (keyToVal.size() == capacity) {
            int keyToRm = freqToKey.get(minFreq).iterator().next();
            keyToVal.remove(keyToRm);
            keyToFreq.remove(keyToRm); // optional
            freqToKey.get(minFreq).remove(keyToRm);
            // minFreq will be set to 1
        }
        
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKey.get(1).add(key);
        minFreq = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */