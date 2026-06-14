class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] pre: prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        Map<Integer, Set<Integer>> prereqMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            dfs(i, adj, prereqMap);
        }

        List<Boolean> answer = new ArrayList<>();
        for (int[] q: queries) {
            answer.add(prereqMap.get(q[0]).contains(q[1]));
        }

        return answer;
    }

    private Set<Integer> dfs(int src, Map<Integer, List<Integer>> adj, Map<Integer, Set<Integer>> prereqMap) {
        if (prereqMap.containsKey(src)) return prereqMap.get(src);
        Set<Integer> prereqs = new HashSet<>();
        for (Integer nei: adj.get(src)) {
            prereqs.addAll(dfs(nei, adj, prereqMap));
        }
        prereqs.add(src);
        prereqMap.put(src, prereqs);

        return prereqs;
    }
}