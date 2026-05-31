class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = count(i, res);
        }

        return res;
    }

    private int count(int n, int[] res) {
        int count = 0;
        while (n > 0) {
            if (res[n] != 0) {
                return res[n] + count;
            }
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }

        return count;
    }
}
