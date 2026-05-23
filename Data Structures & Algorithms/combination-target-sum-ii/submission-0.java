class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, res, new ArrayList<>(), 0, 0, target);
        return res;
    }

    private void helper(int[] candidates, List<List<Integer>> res, List<Integer> comb, int i, int total, int target) {
        if (total == target) {
            res.add(new ArrayList<>(comb));
            return;
        }
        if (i == candidates.length || total > target) {
            return;
        }

        comb.add(candidates[i]);
        helper(candidates, res, comb, i + 1, total + candidates[i], target);
        comb.remove(comb.size() - 1);

        while ( i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        helper(candidates, res, comb, i + 1, total, target);
    }
}
