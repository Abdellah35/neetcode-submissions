class UnionFind {
    Map<Integer, Integer> par;
    Map<Integer, Integer> rank;
    int numComponents;

    public UnionFind(int n) {
        par = new HashMap<>();
        rank = new HashMap<>();
        numComponents = n;

        for (int i = 0; i < n; i++) {
            par.put(i, i);
            rank.put(i, 0);
        }
    }

    public int find(int x) {
        if (x == par.get(x)) {
            return x;
        }
        par.put(x, find(par.get(x)));
        return par.get(x);
    }

    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    public boolean union(int x, int y) {
        int p1 = find(x), p2 = find(y);
        if (p1 == p2) {
            return false;
        }

        if (rank.get(p1) > rank.get(p2)) {
            par.put(p2, p1);
        } else if (rank.get(p2) > rank.get(p1)) {
            par.put(p1, p2);
        } else {
            par.put(p1, p2);
            rank.put(p2, rank.get(p2) + 1);
        }
        numComponents--;

        return true;
    }

    public int getNumComponents() {
        return numComponents;
    }
}
