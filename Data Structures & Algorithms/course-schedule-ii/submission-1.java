class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> visit;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (var pre: prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }
        visit = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, new HashSet<>(), res)) {
                return new int[0];
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int n, Set<Integer> path, List<Integer> res) {
        if (visit.contains(n)) {
            return true;
        }
        if (path.contains(n)) {
            return false;
        }
        path.add(n);
        for (int nei: adj.get(n)) {
            if (!dfs(nei, path, res)) {
                return false;
            }
        }

        path.remove(n);
        visit.add(n);
        res.add(n);
        return true;
    }
}
