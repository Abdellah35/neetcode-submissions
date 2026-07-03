class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxL = 0, maxR = 0;
        int trapped = 0;
        while (l < r) {
            if (height[l] > height[r]) {
                if (height[r] > maxR) {
                    maxR = height[r];
                }
                trapped += maxR - height[r];
                r--;
            } else {
                if (height[l] > maxL) {
                    maxL = height[l];
                }
                trapped += maxL - height[l];
                l++;
            }
        }

        return trapped;
    }
}
