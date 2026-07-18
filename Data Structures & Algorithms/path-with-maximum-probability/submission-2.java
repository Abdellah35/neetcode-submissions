class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Double[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0], d = edges[i][1];
            double w = succProb[i];
            adj.get(s).add(new Double[]{(double) d, w});
            adj.get(d).add(new Double[]{(double) s, w});
        }

        PriorityQueue<Double[]> minHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        minHeap.offer(new Double[]{1.0, (double) start_node});
        Set<Integer> visited = new HashSet<>();
        while(!minHeap.isEmpty()) {
            Double[] node = minHeap.poll();
            int n1 = (int)(double) node[1];
            double p = node[0];
            if (end_node == n1) {
                return p;
            }
            if (visited.contains(n1)) continue;
            visited.add(n1);
            for (var nei: adj.get(n1)) {
                int n2 = (int)(double)nei[0];
                double p2 = nei[1];
                if (!visited.contains(n2)) {
                    minHeap.offer(new Double[]{p * p2, (double) n2});
                }
            }
        }

        return 0;
    }
}