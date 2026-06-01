class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxWater = 0;

        while (l < r) {
            int curVolume = Math.min(heights[r], heights[l])*(r - l);
            maxWater = Math.max(maxWater, curVolume);
            if (heights[r] < heights[l]) {
                r--;
            } else {
                l++;
            }
        }
        
        return maxWater;
    }
}
