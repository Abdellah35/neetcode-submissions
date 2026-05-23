class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        HashMap<Integer, ArrayList<Integer[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<Integer[]>());
        }

        for (List<Integer> edge: edges) {
            int s = edge.get(0), d = edge.get(1), w = edge.get(2);
            adj.get(s).add(new Integer[]{w, d});
        }

        Map<Integer, Integer> shortest = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> (n1[0] - n2[0]));
        minHeap.add(new int[]{0, src});

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.remove();
            int w1 = cur[0], n1 = cur[1];
            if (shortest.containsKey(n1)) {
                continue;
            }

            shortest.put(n1, w1);
            for (Integer[] edge: adj.get(n1)) {
                int w2 = edge[0], n2 = edge[1];
                if (!shortest.containsKey(n2)) {
                    minHeap.add(new int[]{w1 + w2, n2});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            shortest.putIfAbsent(i, -1);
        }

        return shortest;
    }  
}
