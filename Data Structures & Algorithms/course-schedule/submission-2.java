class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adList.put(i, new ArrayList<>());
        }
        for (int[] pr: prerequisites) {
            int src = pr[0], dst = pr[1];
            adList.get(src).add(dst);
        }
        
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adList, i, visited)) return false;
        }

        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> adList, Integer node, Set<Integer> visited) {
        if (visited.contains(node)) return false;
        if (adList.get(node).isEmpty()) return true;

        visited.add(node);
        for (Integer nei: adList.get(node)) {
            if (!dfs(adList, nei, visited)) return false;
        }

        visited.remove(node);
        adList.put(node, new ArrayList<>());
        return true;
    }
        
}
