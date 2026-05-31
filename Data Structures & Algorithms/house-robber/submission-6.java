class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int i = 2;

        while ( i < n) {
            int tmp = dp[1];
            dp[1] = Math.max(tmp, dp[0] + nums[i]);
            dp[0] = tmp;
            i++;
        }

        return dp[1];
    }
}
