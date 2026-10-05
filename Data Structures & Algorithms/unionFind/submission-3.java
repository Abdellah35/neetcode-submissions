class UnionFind {
    int[] parent;
    int[] rank;
    int numComponents;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        numComponents = n;
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

    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    public boolean union(int x, int y) {
        int p1 = find(x), p2 = find(y);
        if (p1 == p2) {
            return false;
        }

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
        } else if (rank[p2] > rank[p1]) {
            parent[p1] = p2;
        } else {
            parent[p1] = p2;
            rank[p2] += 1;
        }
        numComponents--;
        return true;
    }

    public int getNumComponents() {
        return numComponents;
    }
}
