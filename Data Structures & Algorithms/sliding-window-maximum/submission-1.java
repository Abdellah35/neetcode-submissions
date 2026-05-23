class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] res = new int[nums.length - k + 1];
        int m = 0;
        for (int r = 0; r < nums.length; r++) {
            heap.offer(new int[] {nums[r], r});
            if (r >= k -1) {
                while (heap.peek()[1] <= r - k) {
                    heap.poll();
                }
                res[m++] = heap.peek()[0];
            }
        }

        return res;
    }
}
