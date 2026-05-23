class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int top = 0, bot = rows - 1;
        while (top <= bot) {
            int mid = top + (bot - top) / 2;
            if (target > matrix[mid][cols-1]) {
                top = mid + 1;
            } else if (target < matrix[mid][0]) {
                bot = mid - 1;
            } else {
                break;
            }
        }

        if (top > bot) {
            return false;
        }
        int row = top + (bot - top) / 2;

        int l = 0, r = cols - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (target > matrix[row][mid]) {
                l = mid + 1;
            } else if (target < matrix[row][mid]) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
