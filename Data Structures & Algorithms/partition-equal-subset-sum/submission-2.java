class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) {
            return false;
        }
        return dfs(0, nums, 0, total / 2 );
    }

    private boolean dfs(int i, int[] nums, int total, int target) {
        if (total == target) {
            return true;
        }
        if (i >= nums.length) return false;

        if (dfs(i+ 1, nums, total + nums[i], target)) {
            return true;
        } else if (dfs(i + 1, nums, total, target)) {
            return true;
        }

        return false;
    }
}
