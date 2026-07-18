class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Integer[]>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (var time: times) {
            adj.get(time[0]).add(new Integer[]{time[1], time[2]});
        }

        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new Integer[]{0, k});
        int totalTime = 0;
        while(!minHeap.isEmpty()) {
            Integer[] node = minHeap.poll();
            int n1 = node[1], t1 = node[0];
            if (visited.contains(n1)) continue;
            totalTime = t1;
            visited.add(n1);
            for (var nei: adj.get(n1)) {
                int n2 = nei[0], t2 = nei[1];
                if (!visited.contains(n2)) {
                    minHeap.offer(new Integer[]{t1 + t2, n2});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited.contains(i)) {
                return -1;
            }
        }

        return totalTime;
    }
}
