class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<Integer[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (List<Integer> edge: edges) {
            int s = edge.get(0), d = edge.get(1), w = edge.get(2);
            adj.get(s).add(new Integer[]{d, w});
        }

        Queue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        Map<Integer, Integer> shortest = new HashMap<>();
        minHeap.offer(new Integer[]{src, 0});

        while (!minHeap.isEmpty()) {
            Integer[] q = minHeap.remove();
            int d = q[0], w = q[1];
            if (shortest.containsKey(d)) {
                continue;
            }

            shortest.put(d, w);
            for (Integer[] nei: adj.get(d)) {
                if (!shortest.containsKey(nei[0])) {
                    minHeap.offer(new Integer[]{nei[0], nei[1] + w});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!shortest.containsKey(i)) {
                shortest.put(i, -1);
            }
        }

        return shortest;
    }  
}
