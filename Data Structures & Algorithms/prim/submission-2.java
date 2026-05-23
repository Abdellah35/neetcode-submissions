class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Map<Integer, ArrayList<Integer[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (List<Integer> edge: edges) {
            int s = edge.get(0), d = edge.get(1), w = edge.get(2);
            adj.get(s).add(new Integer[]{w, d});
            adj.get(d).add(new Integer[]{w, s});
        }

        Queue<Integer[]> minHeap = new PriorityQueue<>((n1, n2) -> (n1[0] - n2[0]));
        Set<Integer> visit = new HashSet<>();
        visit.add(0);
        for (Integer[] nei: adj.get(0)) {
            minHeap.offer(new Integer[]{nei[0], 0, nei[1]});
        }
        int mst = 0;
        while (!minHeap.isEmpty()) {
            Integer[] cur = minHeap.remove();
            int s = cur[1], d = cur[2], w = cur[0];
            if (visit.contains(d)) {
                continue;
            }
            mst += w;
            visit.add(d);
            for (Integer[] nei: adj.get(d)) {
                if (!visit.contains(nei[1])) {
                    minHeap.offer(new Integer[]{nei[0], d, nei[1]});
                }
            }
        }

        return visit.size() == n ? mst : -1;

    }
}    
