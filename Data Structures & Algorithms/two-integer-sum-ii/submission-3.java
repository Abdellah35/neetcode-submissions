class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> remain = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (remain.containsKey(numbers[i])) return new int[]{remain.get(numbers[i]) + 1, i + 1};
            remain.put(target - numbers[i], i);
        }

        return new int[2];
    }
}
