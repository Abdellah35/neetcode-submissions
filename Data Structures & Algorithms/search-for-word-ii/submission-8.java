class Solution {
    Set<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        TreeNode root = new TreeNode();

        for (String word: words) {
            TreeNode cur = root;
            for (char c: word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TreeNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = true;
        }
        int N = board.length, M = board[0].length;

        boolean[][] visit = new boolean[N][M];
        res = new HashSet<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (root.children[board[r][c] - 'a'] != null) {
                    dfs(r, c, board, "", root, visit);
                }
            }
        }

        return new ArrayList<>(res);
    }

    private void dfs(int r, int c, char[][] board, String word, TreeNode node, boolean[][] visit) {
        int R = board.length, C = board[0].length;
        if (r < 0 || c < 0 || r >= R || c >= C || visit[r][c] || node.children[board[r][c] - 'a'] == null) {
            return;
        }
        char ch = board[r][c];
        visit[r][c] = true;
        word += ch;
        node = node.children[ch - 'a'];
        if (node.word) {
            res.add(word);
        }
        dfs(r + 1, c, board, word, node, visit);
        dfs(r - 1, c, board, word, node, visit);
        dfs(r, c + 1, board, word, node, visit);
        dfs(r, c - 1, board, word, node, visit);
        visit[r][c] = false;
        return;
    }
}

class TreeNode {
    TreeNode[] children;
    boolean word;

    public TreeNode() {
        children = new TreeNode[26];
        word = false;
    }
}
