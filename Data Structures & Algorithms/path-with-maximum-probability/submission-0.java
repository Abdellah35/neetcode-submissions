class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0], d = edges[i][1];
            double p = succProb[i];
            adj.get(s).add(new Pair(d, p));
            adj.get(d).add(new Pair(s, p));
        }

        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;
        Queue<Pair> pq = new PriorityQueue<>((n1, n2) -> Double.compare(n2.prob, n1.prob));
        pq.offer(new Pair(start_node, 1.0));

        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (cur.node == end_node) return cur.prob;
            if (cur.prob < maxProb[cur.node]) {
                continue;
            }
            for (Pair nei: adj.get(cur.node)) {
                double new_prob = nei.prob * cur.prob;
                if (new_prob > maxProb[nei.node]) {
                    maxProb[nei.node] = new_prob;
                    pq.offer(new Pair(nei.node, new_prob));
                }
            }
        }

        return maxProb[end_node];
    }
}

class Pair {
    int node;
    double prob;
    Pair(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }
}