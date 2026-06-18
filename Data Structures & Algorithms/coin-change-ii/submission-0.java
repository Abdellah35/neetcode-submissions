class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, amount, coins, memo);
    }

    private int dfs(int i, int amount, int[] coins, int[][] memo) {
        if (i == coins.length || amount == 0) return amount == 0 ? 1 : 0;
        if (memo[i][amount] != -1) return memo[i][amount];
        memo[i][amount] = dfs(i + 1, amount, coins, memo);

        if (amount >= coins[i]) {
            memo[i][amount] += dfs(i, amount - coins[i], coins, memo);
        }

        return memo[i][amount];
    }
}
