class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] time: times) {
            int u = time[0], v = time[1], t = time[2];
            adj.get(u).add(new int[]{v, t});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, k});
        Map<Integer, Integer> shortest = new HashMap<>();

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int n1 = cur[1], t1 = cur[0];
            if (shortest.containsKey(n1)) continue;
            shortest.put(n1, t1);
            for (int[] nei: adj.get(n1)) {
                int n2 = nei[0], t2 = nei[1];
                minHeap.offer(new int[]{t1 + t2, n2});
            }
        }

        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!shortest.containsKey(i)) return -1;
            res = Math.max(res, shortest.get(i));
        }
        return res;
    }
}
