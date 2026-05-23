class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return helper(0, nums);
    }

    private static List<List<Integer>> helper(int i, int[] nums) {
        if (i == nums.length) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }

        List<List<Integer>> resPerm = new ArrayList<>();
        List<List<Integer>> perms = helper(i + 1, nums);

        for (List<Integer> perm: perms) {
            for (int j = 0; j < perm.size() + 1; j++) {
                List<Integer> pCp = new ArrayList<>();
                pCp.addAll(perm);
                pCp.add(j, nums[i]);
                resPerm.add(pCp);
            }
        }

        return resPerm;
    }
}
