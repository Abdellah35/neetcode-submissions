class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        return dfs(0, nums, target, 0);
    }

    private boolean dfs(int i, int[] nums, int target, int total) {
        if (target == total) return true;
        if (i >= nums.length) return false;

        return dfs(i + 1, nums, target, total + nums[i]) || dfs(i + 1, nums, target, total);
    }
}
