class Solution {
    public boolean exist(char[][] board, String word) {
        int R = board.length, C = board[0].length;
        boolean[][] visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == word.charAt(0) && dfs(board, r, c, visited, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int r, int c, boolean[][] visited, int i, String word) {
        if (i == word.length()) {
            return true;
        } else if ( i == word.length() || r < 0 || r == board.length || c < 0 || c == board[0].length || visited[r][c] || board[r][c] != word.charAt(i)) {
            return false;
        }
        visited[r][c] = true;
        boolean valid = false;
        if (dfs(board, r - 1, c, visited, i + 1, word)) {
            valid = true;
        } else if (dfs(board, r + 1, c, visited, i + 1, word)) {
            valid = true;
        } else if (dfs(board, r, c - 1, visited, i + 1, word)) {
            valid = true;
        } else if (dfs(board, r, c + 1, visited, i + 1, word)) {
            valid = true;
        }
        visited[r][c] = false;
        return valid;
    }
}
