class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Set<Integer> seen = new HashSet<>();
        if (!dfs(adj, 0, seen, 0)) {
            return false;
        }

        return seen.size() == n;
    }

    private boolean dfs(Map<Integer, ArrayList<Integer>> adj, int node, Set<Integer> seen, int parent) {
        if (seen.contains(node)) {
            return false;
        }
        seen.add(node);
        for (int cur: adj.get(node)) {
            if (cur == parent) continue;
            if (!dfs(adj, cur, seen, node)) {
                return false;
            }
        }
        return true;
    }
}
