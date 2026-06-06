class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
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
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges) {
            uf.union(edge[0], edge[1]);
        }

        Set<Integer> roots = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int p = uf.find(i);
            roots.add(p);
        }

        return roots.size();
    }
}
