class Graph {
   Map<Integer, List<Integer>> adjList;
    public Graph() {
       adjList = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        if (!adjList.containsKey(src)) {
           adjList.put(src, new ArrayList<>());
        }
        if (!adjList.containsKey(dst)) {
           adjList.put(dst, new ArrayList<>());
        }
        adjList.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!adjList.containsKey(src) || !adjList.containsKey(dst)) {
            return false;
        }
        if (adjList.get(src).contains(dst)) {
            int indx = adjList.get(src).indexOf(dst);
            adjList.get(src).remove(indx);
            return true;
        }
        return false;
    }

    public boolean hasPath(int src, int dst) {
        return dfs(src, src, dst, new HashSet<Integer>());
    }

    private boolean dfs(int node, int src, int dst, Set<Integer> visit) {
        if (visit.contains(node)) {
            return false;
        }
        if (node == dst) {
            return true;
        }
        boolean exists = false;
        for (int nei: adjList.get(node)) {
            if (!visit.contains(nei)) {
                if (dfs(nei, src, dst, visit)) {
                    exists = true;
                }
                visit.add(nei);
            }
        }
        return exists;
    }
}
