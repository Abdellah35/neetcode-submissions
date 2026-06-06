class UnionFind {
    int[] parent;
    int[] rank;
    int numComponent;
    public UnionFind(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        numComponent = n;
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

    public boolean isSameComponent(int x, int y) {
        int p1 = find(x), p2 = find(y);
        return p1 == p2;
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
        numComponent--;

        return true;
    }

    public int getNumComponents() {
        return numComponent;
    }
}
