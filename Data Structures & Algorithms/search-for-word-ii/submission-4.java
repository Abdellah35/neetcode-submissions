class TrieNode {
    Map<Character, TrieNode> children;
    boolean word;

    public TrieNode() {
        children = new HashMap<>();
        word = false;
    }

    public void addWord(String word) {
        TrieNode cur = this;
        for (char c: word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }

            cur = cur.children.get(c);
        }

        cur.word = true;
    }
}

class Solution {
    Set<String> validWords;
    public List<String> findWords(char[][] board, String[] words) {
        validWords = new HashSet<>();
        TrieNode root = new TrieNode();

        for (String word: words) {
            root.addWord(word);
        }

        int ROWS = board.length, COLS = board[0].length;
        boolean[][] visit = new boolean[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(r, c, "", root, board, visit);
            }
        }

        return new ArrayList<>(validWords);
    }


    private boolean dfs(int r, int c, String word, TrieNode node, char[][] board, boolean[][] visit) {
        int ROWS = board.length, COLS = board[0].length;

        if (r < 0 || c < 0 || r == ROWS || c == COLS || visit[r][c] || !node.children.containsKey(board[r][c])) {
            return false;
        }
        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if (node.word) {
            validWords.add(word);
        }

        dfs(r - 1, c, word, node, board, visit);
        dfs(r + 1, c, word, node, board, visit);
        dfs(r, c - 1, word, node, board, visit);
        dfs(r, c + 1, word, node, board, visit);

        visit[r][c] = false;

        return false;
    }


}
