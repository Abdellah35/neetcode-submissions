class Solution {
    private static final int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestPath(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        HashSet<String> visited = new HashSet<>();
        visited.add(0 + "," + 0);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int length = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }

                for (int[] neighbor: neighbors) {
                    int dr = neighbor[0], dc = neighbor[1];
                    if ((r + dr) < 0 || (c + dc) < 0 || (r + dr) == ROWS || (c + dc) == COLS || visited.contains((r + dr) + "," + (c + dc)) || grid[r + dr][c + dc] == 1 ) continue;
                    queue.add(new int[]{r + dr, c + dc});
                    visited.add((r + dr) + "," + (c + dc));
                }
            }
            length++;
        }

        return -1;
    }
}
