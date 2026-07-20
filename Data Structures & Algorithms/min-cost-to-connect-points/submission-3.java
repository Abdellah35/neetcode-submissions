class Solution {
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        Map<Integer, List<Integer[]>> adj = new HashMap<>();
        for (int i = 0; i < N; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            int[] cord = points[i];
            for (int j = i; j < N; j++) {
                int[] cord2 = points[j];
                int dist = Math.abs(cord[0] - cord2[0]) + Math.abs(cord[1] - cord2[1]);
                adj.get(i).add(new Integer[]{dist, j});
                adj.get(j).add(new Integer[]{dist, i});
            }
        }

        int res = 0;
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new Integer[]{0, 0});
        while (visit.size() < N) {
            Integer[] cur = minHeap.poll();
            int i = cur[1], cost = cur[0];
            if (visit.contains(i)) continue;
            res += cost;
            visit.add(i);
            for (Integer[] nei: adj.get(i)) {
                if (!visit.contains(nei[1])) {
                    minHeap.offer(new Integer[]{nei[0], nei[1]});
                }
            }
        }

        return res;
    }
}
