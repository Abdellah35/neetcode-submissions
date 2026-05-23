class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }

        int max = 0;
        for (int num: numSet) {
            if (!numSet.contains(num - 1)) {
                int curMax = 1;
                while (numSet.contains(num + curMax)) {
                    curMax++;
                }
                max = Math.max(max, curMax);
            }
        }
            
        return max;
    }
}
