class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int fresh = 0;
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int r=0; r < ROWS; r++) {
            for (int c=0; c<COLS; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }


        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] cell = queue.poll();
                for (int[] d: directions) {
                    int dr = cell[0] + d[0], dc = cell[1] + d[1];
                    if (dr >= 0 && dr < ROWS && dc >= 0 && dc < COLS && grid[dr][dc] == 1) {
                        queue.add(new int[]{dr, dc});
                        grid[dr][dc] = 2;
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
