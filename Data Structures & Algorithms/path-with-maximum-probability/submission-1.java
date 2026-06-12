class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Prob>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new Prob(p, v));
            adj.get(v).add(new Prob(p, u));
        }

        boolean[] visit = new boolean[n];
        Queue<Prob> maxHeap = new PriorityQueue<>();
        maxHeap.offer(new Prob(1.0, start_node));

        while(!maxHeap.isEmpty()) {
            Prob cur = maxHeap.poll();
            int n1 = cur.node;
            double p1 = cur.probability;
            if (n1 == end_node) {
                return p1;
            }
            if (visit[n1]) continue;
            visit[n1] = true;
            for (Prob prob: adj.get(n1)) {
                int n2 = prob.node;
                double p2 = prob.probability;
                maxHeap.offer(new Prob(p1 * p2, n2));
            }
        }

        return 0.0;
    }
}

record Prob(double probability, int node) implements Comparable<Prob> {
    @Override
    public int compareTo(Prob other) {
        return Double.compare(other.probability, this.probability);
    }
}