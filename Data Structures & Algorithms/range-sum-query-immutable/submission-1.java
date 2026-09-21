class NumArray {
    List<Integer> prefix;
    public NumArray(int[] nums) {
        prefix = new ArrayList<>();
        int curSum = 0;
        for (int num: nums) {
            curSum += num;
            prefix.add(curSum);
        }
    }
    
    public int sumRange(int left, int right) {
        int rightSum = prefix.get(right);
        int leftSum = left > 0 ? prefix.get(left - 1) : 0;
        return rightSum - leftSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */