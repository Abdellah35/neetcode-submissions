class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (var entry: count.entrySet()) {
            minHeap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            res[i++] = top[1];
        }
        return res;
    }
}
