class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> currSet = new ArrayList<>();
        List<List<Integer>> resSet = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, currSet, resSet);
        return resSet;
    }

    private void helper(int[] nums, int i, List<Integer> currSet, List<List<Integer>> resSet) {
        if (i >= nums.length) {
            resSet.add(new ArrayList<>(currSet));
            return;
        }

        currSet.add(nums[i]);
        helper(nums, i + 1, currSet, resSet);

        currSet.remove(currSet.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        helper(nums, i + 1, currSet, resSet);
    }
}
