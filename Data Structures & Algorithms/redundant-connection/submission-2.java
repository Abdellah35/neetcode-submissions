class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
            rank[i] = 0;
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
        int p1 = find(x), p2 = find(y);
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
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind union = new UnionFind(edges.length);
        for (int[] edge: edges) {
            if (!union.union(edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[]{-1, -1};
    }
}
