class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (List<Integer> edge: edges) {
            int n1 = edge.get(0), n2 = edge.get(1), w = edge.get(2);
            minHeap.offer(new int[]{w, n1, n2});
        }
        UnionFind uf = new UnionFind(n);

        List<Integer[]> mst = new ArrayList<>();
        int total = 0;

        while (mst.size() < n - 1 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int w1 = cur[0], n1 = cur[1], n2 = cur[2];
            if (!uf.union(n1, n2)) continue;
            total += w1;
            mst.add(new Integer[]{n1, n2});
        }

        return mst.size() == n - 1 ? total : -1;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        int p = this.parent[x];
        while (p != this.parent[p]) {
            this.parent[p] = this.parent[this.parent[p]];
            p = this.parent[p];
        }
        return p;
    }

    public boolean union(int x, int y) {
        int p1 = this.find(x), p2 = this.find(y);
        if (p1 == p2) {
            return false;
        }

        if (this.rank[p1] > this.rank[p2]) {
            this.parent[p2] = p1;
        } else if (this.rank[p2] > this.rank[p1]) {
            this.parent[p1] = p2;
        } else {
            this.parent[p1] = p2;
            this.rank[p2] += 1;
        }

        return true;
    }
}
