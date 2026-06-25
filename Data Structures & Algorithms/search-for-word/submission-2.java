class Solution {
    public boolean exist(char[][] board, String word) {
        int N = board.length, M = board[0].length;
        boolean[][] visit = new boolean[N][M];
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (word.charAt(0) == board[r][c]) {
                    if (dfs(0, r, c, board, visit, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int r, int c, char[][] board, boolean[][] visit, String word) {
        if (i >= word.length()) {
            return true;
        }
        int R = board.length, C = board[0].length;
        if (r < 0 || c < 0 || r >= R || c >= C || visit[r][c]) {
            return false;
        }

        visit[r][c] = true;
        char ch = word.charAt(i);
        boolean res = false;
        if (ch == board[r][c]) {
            res = dfs(i + 1, r + 1, c, board, visit, word) || dfs(i + 1, r - 1, c, board, visit, word) ||
                    dfs(i + 1, r, c + 1, board, visit, word) || dfs(i + 1, r, c - 1, board, visit, word);
        }
        
        visit[r][c] = false;
        return res;
    }
}
