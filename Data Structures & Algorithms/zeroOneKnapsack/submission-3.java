class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int N = profit.size(), M = capacity;
        int[] dp = new int[M + 1];
        for (int c = 1; c < M + 1; c++) {
            if (c >= weight.get(0)) {
                dp[c] = profit.get(0);
            }
        }

        for (int i = 1; i < N; i++) {
            int[] curRow = new int[M + 1];
            for (int c = 1; c < M + 1; c++) {
                int skip = dp[c];
                int include = 0;
                if (c >= weight.get(i)) {
                    include = profit.get(i) + dp[c - weight.get(i)];
                }
                curRow[c] = Math.max(include, skip);
            }
            dp = curRow;
        }


        return dp[M]; 
    }
}
