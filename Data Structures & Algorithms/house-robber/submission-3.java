class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[]{nums[0], Math.max(nums[1], nums[0])};
        int i = 2;

        while (i < n) {
            int tmp = dp[1];
            dp[1] = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = tmp;
            i++;
        }

        return Math.max(dp[0], dp[1]);
    }
}