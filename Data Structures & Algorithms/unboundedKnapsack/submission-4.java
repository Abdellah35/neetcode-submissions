class Solution {
    int[][] cache;
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < profit.size(); i++) {
            int[] newRow = new int[capacity + 1];
            for (int c = 0; c < capacity + 1; c++) {
                int skip = dp[c];
                int include = 0;
                if (c >= weight.get(i)) {
                    include = profit.get(i) + newRow[c - weight.get(i)];
                }
                newRow[c] = Math.max(skip, include);
            }

            dp = newRow;
        }

        return dp[capacity];
    }
}
