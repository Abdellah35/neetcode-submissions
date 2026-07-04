class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix.length, M = matrix[0].length;
        int l = 0, r = matrix.length - 1;
        int R = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid][0] <= target && matrix[mid][M - 1] >= target) {
                R = mid;
                break;
            } else if (matrix[mid][0] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (R == Integer.MAX_VALUE) return false;
        l = 0;
        r = M - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == matrix[R][mid]) {
                return true;
            } else if (target > matrix[R][mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
