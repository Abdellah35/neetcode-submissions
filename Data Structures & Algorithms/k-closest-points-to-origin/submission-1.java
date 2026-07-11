class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Integer[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            int distance = x*x + y*y;
            maxHeap.offer(new Integer[]{distance, i});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            Integer[] p = maxHeap.poll();
            res[i++] = points[p[1]];
        }

        return res;
    }
}
