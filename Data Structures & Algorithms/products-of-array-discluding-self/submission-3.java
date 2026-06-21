class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preProd = new int[n];
        int[] postProd = new int[n];
        preProd[0] = 1;
        postProd[n-1] = 1;

        for (int i = 1; i < n; i++) {
            preProd[i] = preProd[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            postProd[i] = postProd[i+1] * nums[i+1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = postProd[i] * preProd[i];
        }

        return res;
    }
}  
