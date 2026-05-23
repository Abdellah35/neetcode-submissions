class Solution {
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        Map<Integer, ArrayList<Integer[]>> adj = new HashMap<>();
        for (int i = 0; i < N; i++) {
            adj.put(i, new ArrayList<Integer[]>());
        }

        for (int i = 0; i < N; i++) {
            int[] point = points[i];
            int x1 = point[0], y1 = point[1];
            for (int j = i + 1; j < N; j++) {
                int[] point2 = points[j];
                int x2 = point2[0], y2 = point2[1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(new Integer[]{dist, j});
                adj.get(j).add(new Integer[]{dist, i});
            }
        }

        int res = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> (n1[0] - n2[0]));
        minHeap.add(new int[]{0, 0});

        while (visited.size() < N) {
            int[] cur = minHeap.remove();
            int cost = cur[0], i = cur[1];
            if (visited.contains(i)) continue;
            res += cost;
            visited.add(i);
            for (Integer[] neigh: adj.get(i)) {
                int neiCost = neigh[0], nei = neigh[1];
                if (!visited.contains(nei)) {
                    minHeap.add(new int[]{neiCost, nei});
                }
            }
        }

        return res;
    }
}
