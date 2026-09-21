class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int tl = 0, tr = r;
        int volume = 0;
        while (l < r) {

            if (height[tl] < height[l]) {
                tl = l;
            }

            if (height[tr] < height[r]) {
                tr = r;
            }

            if (height[l] > height[r]) {
                volume += (Math.min(height[tr], height[tl]) - height[r]);
                r--;
            } else {
                volume += (Math.min(height[tr], height[tl]) - height[l]);
                l++;
            }
        }

        return volume;
    }
}
