class UnionTree {
    Map<Integer, Integer> par;
    Map<Integer, Integer> rank;

    UnionTree(int n) {
        par = new HashMap<>();
        rank = new HashMap<>();

        for (int i=1; i < n + 1; i++) {
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

        return true;
    }

}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionTree union = new UnionTree(edges.length);
        for (int[] edge: edges) {
            if (!union.union(edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }

        return new int[]{-1, -1};
    }
}
