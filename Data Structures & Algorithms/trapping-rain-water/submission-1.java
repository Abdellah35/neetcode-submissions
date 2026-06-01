class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxl = height[l], maxr = height[r];
        int maxWater = 0;

        while (l < r) {
            int curIdx = l;
            if (height[l] < height[r]) {
                curIdx = l++;
            } else {
                curIdx = r--;
            }
            int curVolume = Math.min(maxl, maxr) - height[curIdx];
            maxWater += Math.max(curVolume, 0);

            maxl = Math.max(maxl, height[l]);
            maxr = Math.max(maxr, height[r]);
        }

        return maxWater;
    }
}
