class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c: tasks) {
            count[c - 'A']++;
        }
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Deque<int[]> q = new ArrayDeque<>();
        for (int c: count) {
            if (c > 0)
            maxHeap.add(c);
        }
        int time = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;
            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int task = maxHeap.poll() - 1;
                if (task > 0) {
                    q.add(new int[]{task, time + n});
                }
            }
            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.pop()[0]);
            }
        }

        return time;
    }
}
