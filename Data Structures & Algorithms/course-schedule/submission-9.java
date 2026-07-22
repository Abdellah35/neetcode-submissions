class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> visit;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (var pre: prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        visit = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, new HashSet<>())) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int n, Set<Integer> path) {
        if (visit.contains(n)) {
            return true;
        }
        if (path.contains(n)) {
            return false;
        }
        path.add(n);
        for (int nei: adj.get(n)) {
            if (!dfs(nei, path)) {
                return false;
            }
        }

        path.remove(n);
        visit.add(n);
        return true;
    }
}
