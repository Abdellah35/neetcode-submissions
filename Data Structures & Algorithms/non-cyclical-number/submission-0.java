class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            int sum = squaresSum(n);
            if (seen.contains(sum)) {
                return false;
            }
            seen.add(sum);
            n = sum;
        }

        return true;
    }

    private int squaresSum(int n) {
        int res = 0;
        while (n > 0) {
            int pop = n % 10;
            n /= 10;
            res += (pop * pop);
        }

        return res;
    }
}
