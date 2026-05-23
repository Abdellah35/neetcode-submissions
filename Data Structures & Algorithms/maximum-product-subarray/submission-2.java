class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        int curMax = 1, curMin = 1;
        OptionalInt maxOpt = Arrays.stream(nums).max();

        int res = maxOpt.getAsInt();

        for (int num: nums) {
            int tmp = curMax * num;
            curMax = Math.max(tmp, curMin * num);
            curMax = Math.max(curMax, num);
            curMin = Math.min(tmp, curMin * num);
            curMin = Math.min(curMin, num);
            res = Math.max(res, curMax);
        }
        
        return res;
    }
}
