class UnionFind {
    Map<Integer, Integer> par;
    Map<Integer, Integer> rank;

    UnionFind(int n) {
        par = new HashMap<>();
        rank = new HashMap<>();

        for (int i = 0; i < n; i++) {
            par.put(i, i);
            rank.put(i, 1);
        }
    }

    public int find(int x) {
        if (x != par.get(x)) {
            par.put(x, find(par.get(x)));
        }

        return par.get(x);
    }

    public boolean union(int x, int y) {
        int p1 = find(x), p2 = find(y);

        if (p1 == p2) {
            return false;
        }

        if (rank.get(p1) > rank.get(p2)) {
            par.put(p2, p1);
            rank.put(p1, rank.get(p1) + rank.get(p2));
        } else {
            par.put(p1, p2);
            rank.put(p2, rank.get(p1) + rank.get(p2));
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
            int pr = uf.find(i);
            roots.add(pr);
        }

        return roots.size();
    }
}
