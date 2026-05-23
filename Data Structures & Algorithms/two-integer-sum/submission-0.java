class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int current = nums[i];
            int complement = target - current;
            if (counter.containsKey(complement)) {
                return new int[] {counter.get(complement), i};
            } else {
                counter.put(current, i);
            }
        }

        return new int[] {};
    }
}
