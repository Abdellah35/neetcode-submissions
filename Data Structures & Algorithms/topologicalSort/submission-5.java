class Solution {
    Map<Integer, List<Integer>> adj;
    public List<Integer> topologicalSort(int n, int[][] edges) {
        adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (var edge: edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        Set<Integer> visit = new HashSet<>();
        List<Integer> topological = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!dfs(i, new HashSet<>(), visit, topological)) {
                return new ArrayList<>();
            }
        }

        return topological.reversed();
    }

    private boolean dfs(int i, Set<Integer> path, Set<Integer> visit, List<Integer> topological) {
        if (visit.contains(i)) {
            return true;
        }
        if (path.contains(i)) {
            return false;
        }

        path.add(i);
        for (int nei: adj.get(i)) {
            if (!dfs(nei, path, visit, topological)) {
                return false;
            }
        }
        visit.add(i);
        path.remove(path.size() - 1);
        topological.add(i);
        return true;
    }
}
