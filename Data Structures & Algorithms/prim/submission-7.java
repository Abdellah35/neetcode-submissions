class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Map<Integer, List<Integer[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (var edge: edges) {
            int u = edge.get(0), v = edge.get(1), w = edge.get(2);
            adj.get(u).add(new Integer[]{v, w});
            adj.get(v).add(new Integer[]{u, w});
        }
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        visit.add(0);
        for (var nei: adj.get(0)) {
            minHeap.offer(new Integer[]{nei[1], 0, nei[0]});
        }
        int cost = 0;

        while (!minHeap.isEmpty() && visit.size() < n) {
            Integer[] node = minHeap.poll();
            int s = node[1], d = node[2], w = node[0];
            if (visit.contains(d)) continue;
            visit.add(d);
            cost += w;
            for (var nei: adj.get(d)) {
                if (!visit.contains(nei[0])) {
                    minHeap.offer(new Integer[]{nei[1], d, nei[0]});
                }
            }
        }

        if (visit.size() < n) return -1;

        return cost;
    }
}    
