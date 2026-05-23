class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<Integer[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<Integer[]>());
        }

        for (List<Integer> edge: edges) {
            int s = edge.get(0), d = edge.get(1), w = edge.get(2);
            adj.get(s).add(new Integer[]{d, w}); 
        }

        Queue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> (n1[0] - n2[0]));
        minHeap.add(new int[]{0, src});
        Map<Integer, Integer> shortest = new HashMap<>();
        while(!minHeap.isEmpty()) {
            int[] cur = minHeap.remove();
            int w1 = cur[0], n1 = cur[1];
            if (shortest.containsKey(n1)) continue;

            shortest.put(n1, w1);
            for (Integer[] nei: adj.get(n1)) {
                if (!shortest.containsKey(nei[0])) {
                    minHeap.add(new int[]{nei[1] + w1, nei[0]});
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
