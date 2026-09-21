class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 1;

        while (r < nums.length) {
            if (nums[l] == nums[r] && l > 0 && nums[l - 1] == nums[l]) {
                r++;
            } else {
                nums[++l] = nums[r++];
            }
        }

        return l + 1;
    }
}