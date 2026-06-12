class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (List<Integer> edge: edges) {
            adj.get(edge.get(0)).add(new int[]{edge.get(2), edge.get(1)});
            adj.get(edge.get(1)).add(new int[]{edge.get(2), edge.get(0)});
        }

        Set<Integer> visit = new HashSet<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] nei: adj.get(0)) {
            minHeap.offer(new int[]{nei[0], 0, nei[1]});
        }
        visit.add(0);

        int total = 0;

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            if (visit.contains(cur[2])) continue;
            total += cur[0];
            visit.add(cur[2]);
            if (visit.size() == n) return total;
            
            for (int[] nei: adj.get(cur[2])) {
                if (visit.contains(nei[1])) continue;
                minHeap.offer(new int[]{nei[0], cur[2], nei[1]});
            }
        }

        return -1;
    }
}    
