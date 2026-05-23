class Solution {
    public int shortestPath(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[][] neighbors = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<Integer[]> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.add(new Integer[]{0, 0});
        visited.add(0 + "," + 0);
        int length = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for ( int i = 0; i < size; i++) {
                Integer[] v = q.poll();
                if (v[0] == R - 1 && v[1] == C - 1) {
                    return length;
                }

                for (int[] d: neighbors) {
                    int dr = d[0] + v[0], dc = d[1] + v[1];
                    String pos = dr + "," + dc;
                    if (dr < 0 || dc < 0 || dr == R || dc == C || visited.contains(pos) || grid[dr][dc] == 1) {
                        continue;
                    }
                    q.add(new Integer[]{dr, dc});
                    visited.add(pos);
                }
            }
            length++;
        }

        return -1;
    }
}
