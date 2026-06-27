class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Set<Integer> seen = new HashSet<>();
        if (!dfs(0, adj, seen, -1)) {
            return false;
        }

        return seen.size() == n;
    }

    private boolean dfs(int n, Map<Integer, List<Integer>> adj, Set<Integer> seen, int parent) {
        if (seen.contains(n)) return false;
        
        seen.add(n);
        for (int nei: adj.get(n)) {
            if (nei == parent) continue;
            if (!dfs(nei, adj, seen, n)) {
                return false;
            }
        }

        return true;
    }
}
