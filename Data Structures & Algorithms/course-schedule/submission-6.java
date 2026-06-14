class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] pre: prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adj, visiting, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int src, Map<Integer, List<Integer>> adj, Set<Integer> visiting, Set<Integer> visited) {
        if (visited.contains(src)) return true;
        if (visiting.contains(src)) return false;

        visiting.add(src);
        for (Integer nei: adj.get(src)) {
            if (!dfs(nei, adj, visiting, visited)) {
                return false;
            }
        }

        visiting.remove(src);
        visited.add(src);

        return true;
    }
}
