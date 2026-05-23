class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[m];

        for (int i = n - 1; i >= 0; i--) {
            int[] currRow = new int[m];
            currRow[m - 1] = 1;
            for (int j = m - 2; j >= 0; j--) {
                currRow[j] = currRow[j + 1] + prevRow[j];
            }
            prevRow = currRow;
        }

        return prevRow[0];
    }
}
