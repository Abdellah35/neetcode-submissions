class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return dfs(0, nums, target, 0, memo);
    }

    private boolean dfs(int i, int[] nums, int target, int total, Boolean[][] memo) {
        if (i >= nums.length || total > target) return false;
        if (total == target) return true;
        if (memo[i][total] != null) return memo[i][total];
        memo[i][total] = dfs(i + 1, nums, target, total + nums[i], memo) || dfs(i + 1, nums, target, total, memo);

        return memo[i][total];
    }
}
