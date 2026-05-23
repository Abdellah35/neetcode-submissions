class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> curSet = new ArrayList<>();
        helper(0, nums, subsets, curSet);
        return subsets;
    }

    private void helper(int i, int[] nums, List<List<Integer>> subsets, List<Integer> curSet) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(curSet));
            return;
        }

        curSet.add(nums[i]);
        helper(i + 1, nums, subsets, curSet);
        curSet.remove(curSet.size() - 1);

        helper(i + 1, nums, subsets, curSet);
    }
}
