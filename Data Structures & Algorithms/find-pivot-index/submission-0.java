class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }


        for (int i = 0; i < n; i++) {
            int leftSum = preSum[i];
            int rightSum = preSum[n] - preSum[i + 1];
            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;

    }
}