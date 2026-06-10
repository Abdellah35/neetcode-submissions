class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (List<Integer> edge: edges) {
            int u = edge.get(0), v = edge.get(1), w = edge.get(2);
            adj.get(u).add(new int[]{v, w});
        }

        Map<Integer, Integer> shortest = new HashMap<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, src});
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int n1 = cur[1], w1 = cur[0];
            if (shortest.containsKey(n1)) continue;
            shortest.put(n1, w1);
            for (int[] nei: adj.get(n1)) {
                int n2 = nei[0], w2 = nei[1];
                minHeap.offer(new int[]{w1 + w2, n2});
            }
        }

        for (int i = 0; i < n; i++) {
            shortest.putIfAbsent(i, -1);
        }

        return shortest;
    }  
}
