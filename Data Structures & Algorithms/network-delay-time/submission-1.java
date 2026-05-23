class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            adj.put(i, new ArrayList<int[]>());
        }

        for (int[] time: times) {
            int u = time[0], v = time[1], w = time[2];
            adj.get(u).add(new int[]{v, w});
        }

        Map<Integer, Integer> shortest = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> (n1[0] - n2[0]));
        int t = 0;
        minHeap.add(new int[]{0, k});
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.remove();
            int w1 = cur[0], n1 = cur[1];
            if (shortest.containsKey(n1)) {
                continue;
            }
            shortest.put(n1, w1);
            t = Math.max(t, w1);
            for (int[] time: adj.get(n1)) {
                int n2 = time[0], w2 = time[1];
                if (!shortest.containsKey(n2)) {
                    minHeap.add(new int[]{w1 + w2, n2});
                }
            }
        }

        return shortest.size() == n ? t : -1;
    }
}
