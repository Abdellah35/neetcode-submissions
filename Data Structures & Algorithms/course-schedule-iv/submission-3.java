class Solution {
    Map<Integer, List<Integer>> adj;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (var pre: prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        Map<Integer, Set<Integer>> visit = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            dfs(i, visit);
        }
        List<Boolean> res = new ArrayList<>();
        for (var q: queries) {
            res.add(visit.get(q[0]).contains(q[1]));
        }

        return res;
    }

    private Set<Integer> dfs(int n, Map<Integer, Set<Integer>> visit) {
        if (visit.containsKey(n)) {
            return visit.get(n);
        }

        Set<Integer> pre = new HashSet<>();
        for (int nei: adj.get(n)) {
            pre.addAll(dfs(nei, visit));
        }
        pre.add(n);
        visit.put(n, pre);

        return pre;
    }
}