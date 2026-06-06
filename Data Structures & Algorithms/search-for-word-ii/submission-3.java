class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();

        for (String word: words) {
            if (helper(word, board)) {
                res.add(word);
            }
        }

        return res;
    }

    private boolean helper(String word, char[][] board) {
        int ROWS = board.length, COLS = board[0].length;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(r, c, word, 0, board, new boolean[ROWS][COLS])) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean dfs(int r, int c, String word, int i, char[][] board, boolean[][] visit) {
        int ROWS = board.length, COLS = board[0].length;
        if (i == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r == ROWS || c == COLS || visit[r][c]) {
            return false;
        }

        char ch = word.charAt(i);
        if (board[r][c] != ch) {
            return false;
        }
        visit[r][c] = true;

        if (dfs(r - 1, c, word, i + 1, board, visit) || dfs(r + 1, c, word, i + 1, board, visit) || dfs(r, c - 1, word, i + 1, board, visit) || dfs(r, c + 1, word, i + 1, board, visit)) {
            return true;
        }

        visit[r][c] = false;

        return false;
    }


}
