class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] pre: prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> courseOrder = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adj, visiting, visited, courseOrder)) {
                return new int[]{};
            }
        }

        return courseOrder.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int src, Map<Integer, List<Integer>> adj, Set<Integer> visiting, Set<Integer> visited, List<Integer> courseOrder) {
        if (visited.contains(src)) return true;
        if (visiting.contains(src)) return false;

        visiting.add(src);
        for (Integer nei: adj.get(src)) {
            if (!dfs(nei, adj, visiting, visited, courseOrder)) {
                return false;
            }
        }

        visiting.remove(src);
        visited.add(src);
        courseOrder.add(src);
        return true;
    }
}
