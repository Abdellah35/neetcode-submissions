class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().orElse(0);
        int l = 1, r = max, res = max;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int hours = 0;
            for (int p: piles) {
                hours += Math.ceil((double) p / mid);
            }
            if (hours <= h) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }
}
