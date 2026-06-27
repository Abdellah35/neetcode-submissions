class Solution {
    public int coinChange(int[] coins, int amount) {
        return dfs(0, coins, amount);
    }

    private int dfs(int i, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0 || i >= coins.length) return -1;

        int res = dfs(i, coins, amount - coins[i]);
        int skip = dfs(i + 1, coins, amount);
        if (res == -1 || skip == -1) {
            if (res == -1) {
                res = skip;
            } else if (skip == -1) {
                res += 1;
            }
        } else {
            res = Math.min(res + 1, skip);
        }

        return res;
    }
}
