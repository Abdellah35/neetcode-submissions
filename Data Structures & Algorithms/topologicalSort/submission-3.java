class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        List<Integer> topSort = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            if (!dfs(i, adj, visit, topSort, new HashSet<>())){
                return new ArrayList<>();
            }
        }
        Collections.reverse(topSort);
        return topSort;
    }

    private boolean dfs(int src, Map<Integer, List<Integer>> adj, Set<Integer> visit, List<Integer> topSort, Set<Integer> path) {
        if (visit.contains(src)) {
            return true;
        }
        if (path.contains(src)) {
            return false;
        }
        path.add(src);
        for (Integer nei: adj.get(src)) {
            if (!dfs(nei, adj, visit, topSort, path)) {
                return false;
            }
        }
        
        path.remove(path.size() - 1);
        visit.add(src);
        topSort.add(src);
        return true;
    }
}
