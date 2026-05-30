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
        return bfs(src, dst);
    }

    private boolean bfs(int src, int dst) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        Set<Integer> visit = new HashSet<>();
        visit.add(src);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                if (node == dst) {
                    return true;
                }

                for (int nei: adjList.get(node)) {
                    if (visit.contains(nei)) {
                        continue;
                    }
                    queue.add(nei);
                    visit.add(nei);
                }
            }
        }
        
        return false;
    }
}
