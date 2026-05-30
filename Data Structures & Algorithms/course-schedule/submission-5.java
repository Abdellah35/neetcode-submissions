class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] preq: prerequisites) {
            adjList.get(preq[0]).add(preq[1]);
        }
        int[] states = new int[numCourses];
        Arrays.fill(states, 0);
        for (int i = 0; i < numCourses; i++) {
            if (states[i] == 0) {
                if (!dfs(i, states, adjList)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int course, int[] states, Map<Integer, List<Integer>> adjList) {
        if (states[course] == 1) {
            return false;
        }
        if (states[course] == 2) {
            return true;
        }
        states[course] = 1;
        for (int pre: adjList.get(course)) {
            if (!dfs(pre, states, adjList)) {
                return false;
            }
        }
        states[course] = 2;

        return true;
    }
}
