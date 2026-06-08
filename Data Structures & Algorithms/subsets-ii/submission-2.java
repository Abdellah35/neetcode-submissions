class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<>(), subsets);
        return subsets; 
    }

    private void helper(int i, int[] nums, List<Integer> curSet, List<List<Integer>> subsets) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(curSet));
            return;
        }

        curSet.add(nums[i]);
        helper(i + 1, nums, curSet, subsets);

        curSet.remove(curSet.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        helper(i + 1, nums, curSet, subsets);
    }
}
