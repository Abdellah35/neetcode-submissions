class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(memo[i], -2);
        }
        return dfs(0, coins, amount, memo);
    }

    private int dfs(int i, int[] coins, int amount, int[][] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0 || i >= coins.length) return -1;
        if (memo[i][amount] != -2) return memo[i][amount];
        int res = dfs(i, coins, amount - coins[i], memo);
        int skip = dfs(i + 1, coins, amount, memo);
        if (res == -1 || skip == -1) {
            if (res == -1) {
                res = skip;
            } else if (skip == -1) {
                res += 1;
            }
        } else {
            res = Math.min(res + 1, skip);
        }
        memo[i][amount] = res;
        return memo[i][amount];
    }
}
