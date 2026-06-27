class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] pre: prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        for (int[] pre: prerequisites) {
            if (!dfs(pre[0], adj, new HashSet<>())) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> adj, Set<Integer> visit) {
        if (adj.get(course).size() == 0) return true;
        if (visit.contains(course)) return false;

        visit.add(course);
        for (int preq: adj.get(course)) {
            if (!dfs(preq, adj, visit)) {
                return false;
            }
        }

        adj.put(course, new ArrayList<>());
        return true;
    }
}
