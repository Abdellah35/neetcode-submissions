class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), subsets);
        return subsets;
    }

    private void dfs(int i, int[] nums, List<Integer> subset, List<List<Integer>> subsets) {
        if (i == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(i + 1, nums, subset, subsets);

        subset.remove(subset.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        dfs(i + 1, nums, subset, subsets);
    }
}
