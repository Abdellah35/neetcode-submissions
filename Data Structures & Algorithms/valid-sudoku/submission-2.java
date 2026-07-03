class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] col = new HashSet[9];
        Set<Character>[] row = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            col[i] = new HashSet<>();
            row[i] = new HashSet<>();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int r = i * 3, c = j * 3;
                Set<Character> subBox = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[r + k][c + l] == '.') continue;
                        char ch = board[r + k][c + l];
                        if (subBox.contains(ch) || row[r + k].contains(ch) || col[c + l].contains(ch)) return false;
                        
                        subBox.add(ch);
                        col[c + l].add(ch);
                        row[r + k].add(ch);
                    }
                }
            }
        }

        return true;
    }
}
