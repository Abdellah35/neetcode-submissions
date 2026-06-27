class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> seen = new HashSet<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (seen.contains(i)) continue;
            dfs(i, adj, seen, -1);
            count++;
        }

        return count;
    }

    private void dfs(int node, Map<Integer, List<Integer>> adj, Set<Integer> seen, int parent) {
        if (seen.contains(node)) return;
        seen.add(node);
        for (int nei: adj.get(node)) {
            if (nei == parent) continue;
            dfs(nei, adj, seen, node);
        }
    }
}
