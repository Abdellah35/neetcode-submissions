class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 0;
        int n = nums.length;

        while (r < n) {
            nums[l] = nums[r];
            while (r < n - 2 && nums[r] == nums[r + 1] && nums[r + 1] == nums[r + 2]) {
                r++;
            }
            r++;
            l++;
        }
        return l;
    }
}