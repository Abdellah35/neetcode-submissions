class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preProd = new int[n];
        int[] postProd = new int[n];
        Arrays.fill(preProd, 1);
        Arrays.fill(postProd, 1);
        int prev1 = 1, prev2 = 1;
        for (int i = 0; i < n; i++) {
            preProd[i] = nums[i] * prev1;
            prev1 = preProd[i];
            postProd[n-1-i] = nums[n - 1 - i] * prev2;
            prev2 = postProd[n-1-i]; 
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && i < n - 1) {
                res[i] = postProd[i + 1] * preProd[i - 1];
            } else if (i <= 0) {
                res[i] = postProd[i + 1];
            } else {
                res[i] = preProd[i - 1];
            }
        }

        return res;
    }
}  
