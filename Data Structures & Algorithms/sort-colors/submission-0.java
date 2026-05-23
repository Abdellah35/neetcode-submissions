class Solution {
    public void sortColors(int[] nums) {
        int[] count = {0, 0, 0};

        for (int num: nums) {
            count[num] += 1;
        }

        int i = 0;

        for (int n=0; n < count.length; n++) {
            for (int j=0; j < count[n]; j++) {
                nums[i] = n;
                i++;
            }
        }
    }
}