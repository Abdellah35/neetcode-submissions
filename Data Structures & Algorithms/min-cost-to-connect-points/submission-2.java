class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dst = Math.abs(points[i][0] - points[j][0]) + 
                        Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{dst, i, j});
            }
        }

        edges.sort((a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        for (int[] edge: edges) {
            if (uf.union(edge[1], edge[2])) {
                res += edge[0];
            }
        }

        return res;
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