class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            prefix[i] = left;
            suffix[n - 1 - i] = right;
            left += nums[i];
            right += nums[n - 1 - i];
        }

        for (int i = 0; i < n; i++) {
            if (suffix[i] == prefix[i]) {
                return i;
            }
        }

        return -1;

    }
}