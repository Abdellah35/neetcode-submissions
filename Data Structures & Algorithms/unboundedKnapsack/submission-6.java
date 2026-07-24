class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int N = profit.size(), M = capacity + 1;
        int[] prevRow = new int[M];

        for (int i = 0; i < N; i++) {
            int[] curRow = new int[M];
            for (int c = 0; c < M; c++) {
                int skip = prevRow[c];
                int include = 0;
                if (c >= weight.get(i)) {
                    include = profit.get(i) + curRow[c - weight.get(i)];
                }
                curRow[c] = Math.max(skip, include);
            }
            prevRow = curRow;
        }

        return prevRow[M - 1];
    }
}
