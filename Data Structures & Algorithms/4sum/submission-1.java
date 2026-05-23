class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> combs = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, target, new ArrayList<>(), combs);
        return combs;
    }

    private void dfs(int i, int[] nums, int target, List<Integer> curComb, List<List<Integer>> combs) {
        if (curComb.size() == 4) {
            long sum = (long) curComb.get(0) + curComb.get(1) + curComb.get(2) + curComb.get(3);
            System.out.println(sum);
            if (sum == target)
            combs.add(new ArrayList<>(curComb));
            return;
        }
        if (i >= nums.length) {
            return;
        }

        curComb.add(nums[i]);
        dfs(i + 1, nums, target, curComb, combs);
        curComb.remove(curComb.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        dfs(i + 1, nums, target, curComb, combs);
    }
}