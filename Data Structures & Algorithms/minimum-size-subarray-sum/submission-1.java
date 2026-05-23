class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int curTotal = 0;
        int L = 0;
        for ( int R = 0; R < nums.length; R++) {
            curTotal += nums[R];
            while (L <= R && curTotal >= target) {
                minLength = Math.min(minLength, R - L + 1);
                curTotal -= nums[L++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}