class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) {
                r -= 1;
            } else if (sum < target) {
                l += 1;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }

        return new int[]{-1, -1};
    }
}
