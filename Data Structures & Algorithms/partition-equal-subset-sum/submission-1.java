class Solution {
    Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0; 
        for (int num: nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        memo = new Boolean[n][sum / 2 + 1];
        return dfs(0, nums, sum / 2);
    }

    private boolean dfs(int i, int[] nums, int target) {
        if (i == nums.length) {
            return target == 0;
        }
        if (target < 0) {
            return false;
        }
        if (memo[i][target] != null) {
            return memo[i][target];
        }
        memo[i][target] = dfs(i + 1, nums, target) || dfs(i + 1, nums, target - nums[i]);

        return memo[i][target];
    }
}
