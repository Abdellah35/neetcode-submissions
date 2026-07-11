class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char ch: tasks) {
            count[ch - 'A']++;
        }
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int cnt: count) {
            if (cnt > 0) maxHeap.offer(cnt);
        }

        Deque<int[]> q = new ArrayDeque<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    q.add(new int[]{cnt, time + n});
                }
            } else {
                time = q.peek()[1];
            }
            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.offer(q.pop()[0]);
            }
        }

        return time;
    }
}
