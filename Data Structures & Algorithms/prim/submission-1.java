class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Map<Integer, ArrayList<Integer[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<Integer[]>());
        }

        for (List<Integer> edge: edges) {
            int s = edge.get(0), d = edge.get(1), w = edge.get(2);
            adj.get(s).add(new Integer[]{w, d});
            adj.get(d).add(new Integer[]{w, s});
        }

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> (n1[0] - n2[0]));
        for (Integer[] neigh: adj.get(0)) {
            minHeap.add(new int[]{neigh[0], 0, neigh[1]});
        }
        visited.add(0);
        int total = 0;
        List<Integer[]> mst = new ArrayList<>();

        while (visited.size() < n) {
            if (minHeap.isEmpty()) return -1;
            int[] cur = minHeap.remove();
            int w1 = cur[0], n1 = cur[1], n2 = cur[2];
            if (visited.contains(n2)) continue;
            mst.add(new Integer[]{n1, n2});
            total += w1;
            visited.add(n2);
            for (Integer[] neigh: adj.get(n2)) {
                int w2 = neigh[0], node = neigh[1];
                if (!visited.contains(node)) {
                    minHeap.add(new int[]{w2, n2, node});
                }
            }
        }

        return total;
    }
}    
