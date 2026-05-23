class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxVolume = 0;

        while (l < r) {
            int curVolume = Math.min(heights[l], heights[r]) * (r - l);
            maxVolume = Math.max(maxVolume, curVolume);

            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }

        return maxVolume;
    }
}
