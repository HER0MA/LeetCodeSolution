class Node {
    String word;
    Node[] children;
    
    Node () {
        children = new Node[26];
    }
}
// t: m*n*len(word) s:len(word)
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for (String word : words) {
            add(word, root);
        }
        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(i, j, root, board, res);
            }
        }
        return new ArrayList<>(res);
    }
    
    private void add(String word, Node root) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (root.children[ch - 'a'] == null) {
                root.children[ch - 'a'] = new Node();
            }
            root = root.children[ch - 'a'];
        }
        root.word = word;
    }
    
    private void search(int i, int j, Node node, char[][] board, Set<String> res) {
        // check if current prefix is in dictionary first
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) return;
        char ch = board[i][j];
        if (ch == '*' || node.children[ch - 'a'] == null) return;
        node = node.children[ch - 'a'];
        if (node.word != null) res.add(node.word);
        board[i][j] = '*';
        search(i - 1, j, node, board, res);
        search(i, j - 1, node, board, res);
        search(i + 1, j, node, board, res);
        search(i, j + 1, node, board, res);
        board[i][j] = ch;
    }
}