class UnionFind {
    Map<Integer, Integer> par;
    Map<Integer, Integer> rank;

    UnionFind(int n) {
        par = new HashMap<>();
        rank = new HashMap<>();

        for (int i = 0; i < n + 1; i++) {
            par.put(i, i);
            rank.put(i, 1);
        }
    }

    public int find(int n) {
        int p = par.get(n);
        if (p != par.get(p)) {
            p = find(par.get(p));
        }

        return p;
    }

    public boolean union(int x, int y) {
        int p1 = find(x), p2 = find(y);
        if (p1 == p2) {
            return false;
        }

        if (rank.get(p1) > rank.get(p2)) {
            par.put(p2, p1);
        } else if (rank.get(p1) < rank.get(p2)) {
            par.put(p1, p2);
        } else {
            par.put(p1, p2);
            rank.put(p2, rank.get(p2) + 1);
        }

        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind node = new UnionFind(edges.length);
        int[] res = new int[]{-1, -1};
        for (int[] edge: edges) {
            if (!node.union(edge[0], edge[1])) {
                res = edge;
            }
        }

        return res;
    }
}
