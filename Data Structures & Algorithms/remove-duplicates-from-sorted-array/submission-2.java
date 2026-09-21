class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != nums[l]) {
                nums[l + 1] = nums[r];
                l++;
            }
            r++;
        }

        return l + 1;
    }
}