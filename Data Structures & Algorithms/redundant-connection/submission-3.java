class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);
        for (int[] edge: edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[]{-1, -1};
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
        }
    }

    public int find(int x) {
        int p = parent[x];
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

    public boolean union(int x, int y) {
        int p1 = find(x), p2 = find(y);
        if (p1 == p2) {
            return false;
        }

        if (rank[p1] > parent[p2]) {
            parent[p2] = p1;
        } else if (rank[p1] < parent[p2]) {
            parent[p1] = p2;
        } else {
            parent[p1] = p2;
            rank[p2] += 1;
        }

        return true;
    }
}
