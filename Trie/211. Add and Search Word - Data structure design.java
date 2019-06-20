class Node {
    boolean isWord;
    Node[] children;
    
    Node() {
        isWord = false;
        children = new Node[26];
    }
}

class WordDictionary {
    private Node root = new Node();
    
    /** Adds a word into the data structure. */
    // t:n
    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Node();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    // t:n worst: n^26
    public boolean search(String word) {
        return searchHelper(0, word, root);
    }
    
    private boolean searchHelper(int idx, String word, Node curr) {
        if (curr == null) return false;
        if (idx == word.length()) {
            return curr.isWord;
        }
        char ch = word.charAt(idx);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (searchHelper(idx + 1, word, curr.children[i])) {
                    return true;
                }
            }
            return false;
        } else if (curr.children[ch - 'a'] != null) {
            return searchHelper(idx + 1, word, curr.children[ch - 'a']);
        } else {
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */