class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<Integer[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (var edge: edges) {
            int s = edge.get(0), d = edge.get(1), w = edge.get(2);
            adj.get(s).add(new Integer[]{d, w});
        }

        Map<Integer, Integer> shortest = new HashMap<>();
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new Integer[]{0, src});

        while (!minHeap.isEmpty()) {
            Integer[] node = minHeap.poll();
            int n1 = node[1], w1 = node[0];
            if (shortest.containsKey(n1)) continue;
            shortest.put(n1, w1);
            for (var nei: adj.get(n1)) {
                int n2 = nei[0], w2 = nei[1];
                if (!shortest.containsKey(n2)) {
                    minHeap.offer(new Integer[]{w1 + w2, n2});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            shortest.putIfAbsent(i, -1);
        }

        return shortest;
    }  
}
