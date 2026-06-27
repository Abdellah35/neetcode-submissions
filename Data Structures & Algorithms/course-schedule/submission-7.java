class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] pre: prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        Map<Integer, Boolean> memo = new HashMap<>();
        for (int[] pre: prerequisites) {
            if (!dfs(pre[0], adj, memo, new HashSet<>())) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> adj, Map<Integer, Boolean> memo, Set<Integer> visit) {
        if (memo.containsKey(course)) return memo.get(course);
        if (adj.get(course).size() == 0) return true;
        if (visit.contains(course)) return false;

        visit.add(course);
        for (int preq: adj.get(course)) {
            if (!dfs(preq, adj, memo, visit)) {
                memo.put(course, false);
                return false;
            }
        }

        memo.put(course, true);
        return true;
    }
}
