class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int L = 0, curSum = 0;
        int length = Integer.MAX_VALUE;

        for (int R = 0; R < nums.length; R++) {
            curSum += nums[R];
            while (curSum >= target) {
                length = Math.min(R - L + 1, length);
                curSum -= nums[L];
                L += 1;
            }
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }
}