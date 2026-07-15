class Solution {
    public List<List<Integer>> subsets(int[] nums) {
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
        dfs(i + 1, nums, subset, subsets);
    }
}
