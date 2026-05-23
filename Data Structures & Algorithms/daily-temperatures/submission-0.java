class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer[]> monStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!monStack.isEmpty() && monStack.peek()[1] < temperatures[i]) {
                Integer[] cur = monStack.pop();
                res[cur[0]] = i - cur[0];
            }
            monStack.push(new Integer[]{i, temperatures[i]});
        }

        return res;
    }
}
