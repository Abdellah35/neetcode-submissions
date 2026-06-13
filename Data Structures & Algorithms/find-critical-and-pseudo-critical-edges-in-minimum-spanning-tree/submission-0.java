class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<int[]> edgeList = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            edgeList.add(new int[]{edges[i][0], edges[i][1], edges[i][2], i});
        }

        edgeList.sort(Comparator.comparingInt(a -> a[2]));

        UnionFind uf = new UnionFind(n);
        int mstW = 0;
        for (int[] edge: edgeList) {
            if (uf.union(edge[0], edge[1])) {
                mstW += edge[2];
            }
        }

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int[] edge: edgeList) {
            UnionFind ufWithout = new UnionFind(n);
            int weight = 0;
            for (int[] other: edgeList) {
                if (other[3] != edge[3] && ufWithout.union(other[0], other[1])) {
                    weight += other[2];
                }
            }

            if (Arrays.stream(ufWithout.rank).max().getAsInt() != n || weight > mstW) {
                critical.add(edge[3]);
                continue;
            }

            UnionFind ufWith = new UnionFind(n);
            ufWith.union(edge[0], edge[1]);
            weight = edge[2];
            for (int[] other: edgeList) {
                if (ufWith.union(other[0], other[1])) {
                    weight += other[2];
                }
            }

            if (weight == mstW) {
                pseudo.add(edge[3]);
            }
        }

        return Arrays.asList(critical, pseudo);
    }
}

class UnionFind {
    int[] parent, rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
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

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        return true;
    }
}