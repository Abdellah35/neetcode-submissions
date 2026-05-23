class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<Integer>());
        }

        for (int[] edge: edges) {
            int s = edge[0], d = edge[1];
            adj.get(s).add(d);
        }

        List<Integer> topSort = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if(!dfs(i, adj, topSort, visited, visiting)) {
                return new ArrayList<>();
            }
        }
        Collections.reverse(topSort);
        return topSort;
    }

    private boolean dfs(int src, Map<Integer, ArrayList<Integer>> adj, List<Integer> topSort, Set<Integer> visited, Set<Integer> visiting) {
        if (visited.contains(src)) {
            return true;
        }

        if (visiting.contains(src)) {
            return false;
        }

        visiting.add(src);
        for (Integer nei: adj.get(src)) {
            if (!dfs(nei, adj, topSort, visited, visiting)) {
                return false;
            }
        }
        visiting.remove(src);
        visited.add(src);
        topSort.add(src);
        return true;
    }
}
