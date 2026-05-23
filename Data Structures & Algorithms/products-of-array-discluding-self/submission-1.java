class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preProd = new int[n];
        int[] postProd = new int[n];
        int left = 1;
        int right = 1;
        for (int i = 0; i < n; i++) {
            preProd[i] = left;
            postProd[n - 1 - i] = right;
            left *= nums[i];
            right *= nums[n - 1 - i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = preProd[i] * postProd[i];
        }

        return nums;
    }
}  
