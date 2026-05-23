class Solution {
    public int[] plusOne(int[] digits) {
        int res = 0;
        int remainder = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + remainder;
            if (sum <= 9) {
                digits[i] = sum;
                remainder = 0;
                return digits;
            } else {
                digits[i] = 0;
                remainder = 1;
            }
        }
        if (remainder == 1) {
            List<Integer> newList = Arrays.stream(digits).boxed().collect(Collectors.toList());
            newList.add(0, remainder);
            digits = newList.stream().mapToInt(Integer::intValue).toArray();
        }
        return digits;
    }
}
