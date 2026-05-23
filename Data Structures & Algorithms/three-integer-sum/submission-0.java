class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (i > 0 && nums[i - 1] == a) continue;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = a + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(new ArrayList(Arrays.asList(a, nums[l], nums[r])));
                    l++;
                    while (nums[l - 1] == nums[l] && l < r) {
                        l++;
                    }
                }
            }
        }

        return res;
    }
}
