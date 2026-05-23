class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> curSet = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, subsets, curSet);
        return subsets;
    }

    private void helper(int i, int[] nums, List<List<Integer>> subsets, List<Integer> curSet) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(curSet));
            return;
        }

        //include nums[i]
        curSet.add(nums[i]);
        helper(i + 1, nums, subsets, curSet);
        curSet.remove(curSet.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        helper(i + 1, nums, subsets, curSet);
    }
}
