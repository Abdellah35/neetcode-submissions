class Solution {
    Set<String> result;
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word: words) {
            trie.addWord(word);
        }
        result = new HashSet<>();

        int R = board.length, C = board[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                dfs(r, c, board, trie.root, new StringBuilder(), new boolean[R][C]);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(int r, int c, char[][] board, TrieNode node, StringBuilder sb, boolean[][] visit) {
        int R = board.length, C = board[0].length;
        if (r < 0 || c < 0 || r == R || C == c || visit[r][c] || !node.children.containsKey(board[r][c])) {
            return;
        }

        node = node.children.get(board[r][c]);
        sb.append(board[r][c]);
        if (node.word) {
            result.add(sb.toString());
        }
        visit[r][c] = true;
        dfs(r - 1,c, board, node, sb, visit);
        dfs(r + 1,c, board, node, sb, visit);
        dfs(r,c - 1, board, node, sb, visit);
        dfs(r,c + 1, board, node, sb, visit);
        visit[r][c] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch: word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.word = true;
    }

    public boolean search(String word) {
        TrieNode node = root;

        for (char ch: word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }

        return node.word;
    }
}


class TrieNode {
    Map<Character, TrieNode> children;
    boolean word;

    public TrieNode() {
        children = new HashMap<>();
        word = false;
    }
}