class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (var edge: edges) {
            minHeap.offer(new Integer[]{edge.get(2), edge.get(0), edge.get(1)});
        }

        UnionFind un = new UnionFind(n);
        int total = 0;
        List<Integer[]> mst = new ArrayList<>();
        while (mst.size() < n - 1 && !minHeap.isEmpty()) {
            Integer[] cur = minHeap.poll();
            int w = cur[0], n1 = cur[1], n2 = cur[2];
            if (!un.union(n1, n2)) continue;
            total += w;
            mst.add(new Integer[]{n1, n2});
        }

        return mst.size() < n - 1 ? -1 : total;
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
        int p = parent[x];
        if (parent[p] != p) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    public boolean union(int x, int y) {
        int n1 = find(x), n2 = find(y);

        if (n1 == n2) return false;

        if (rank[n1] > rank[n2]) {
            parent[n2] = n1;
        } else if (rank[n2] > rank[n1]) {
            parent[n1] = n2;
        } else {
            parent[n1] = n2;
            rank[n2] += 1;
        }

        return true;
    }
}
