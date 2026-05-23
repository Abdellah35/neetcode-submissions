class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        int[] postSum = new int[n];
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            preSum[i] = left;
            postSum[n - 1 - i] = right;
            right += nums[n - 1 - i];
            left += nums[i];
        }

        for (int i = 0; i < n; i++) {
            if (preSum[i] == postSum[i]) {
                return i;
            }
        }

        return -1;
    }
}