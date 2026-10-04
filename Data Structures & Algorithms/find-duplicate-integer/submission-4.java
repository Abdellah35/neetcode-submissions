class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n];

        for (int num: nums) {
            if (arr[num] > 0) {
                return num;
            }
            arr[num]++;
        }

        return -1;
    }
}
