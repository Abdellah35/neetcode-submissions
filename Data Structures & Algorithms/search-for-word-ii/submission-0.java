class TrieNode {
    boolean word;
    Map<Character, TrieNode> children;

    TrieNode() {
        word = false;
        children = new HashMap<>();
    }

    public void addWord(String word) {
        TrieNode root = this;
        for (char c: word.toCharArray()) {
            root.children.putIfAbsent(c, new TrieNode());
            root = root.children.get(c);
        }
        root.word = true;
    }
}

class Solution {
    Set<String> res;
    boolean[][] visit;

    public List<String> findWords(char[][] board, String[] words) {
        int R = board.length, C = board[0].length;
        TrieNode root = new TrieNode();
        for (String word: words) {
            root.addWord(word);
        }

        visit = new boolean[R][C];
        res = new HashSet<>();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                helper(board, r, c, root, "");
            }
        }

        return new ArrayList<>(res);
    }

    private void helper(char[][] board, int r, int c, TrieNode node, String word) {
        int R = board.length, C = board[0].length;
        if (r < 0 || c < 0 || r >= R || c >= C || visit[r][c] || !node.children.containsKey(board[r][c])) {
            return;
        }

        visit[r][c] = true;
        word += board[r][c];
        node = node.children.get(board[r][c]);
        if (node.word) {
            res.add(word);
        }

        helper(board, r + 1, c, node, word);
        helper(board, r - 1, c, node, word);
        helper(board, r, c + 1, node, word);
        helper(board, r, c - 1, node, word);

        visit[r][c] = false;
    }
}
