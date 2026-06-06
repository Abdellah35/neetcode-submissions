class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 1) return 0;
        Arrays.sort(nums);
        int longest = 1;
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                cur++;
                longest = Math.max(longest, cur);
            } else if (nums[i] != nums[i - 1]) {
                cur = 1;
            }
        }
        return longest;
    }
}
