class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;

        for (int num: nums) {
            currSum = Math.max(currSum, 0);
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
