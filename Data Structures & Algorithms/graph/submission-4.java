class Graph {
    Map<Integer, List<Integer>> adj;
    public Graph() {
        adj = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        adj.putIfAbsent(src, new ArrayList<>());
        adj.putIfAbsent(dst, new ArrayList<>());
        adj.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (adj.containsKey(src)) {
            if (adj.get(src).remove(Integer.valueOf(dst))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPath(int src, int dst) {
        return dfs(src, dst, new HashSet<>());
    }

    private boolean dfs(int node, int target, Set<Integer> visit) {
        if (visit.contains(node)) {
            return false;
        }
        if (node == target) {
            return true;
        }

        visit.add(node);
        for (int nei: adj.get(node)) {
            if (dfs(nei, target, visit)) {
                return true;
            }
        }

        return false;
    }
}
