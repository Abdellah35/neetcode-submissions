class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int L = 0, total = 0;
        int length = Integer.MAX_VALUE;

        for (int R = 0; R < nums.length; R++) {
            total += nums[R];
            while (total >= target) {
                length = Math.min(R - L + 1, length);
                total -= nums[L];
                L++;
            }
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }
}