class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int maxTurbulence = 1;
        int sign = 0;
        int L = 0;

        for (int R = 1; R < arr.length; R++) {
            if ( arr[R - 1] > arr[R] && sign != -1) {
                sign = -1;
            } else if (arr[R - 1] < arr[R] && sign != 1) {
                sign = 1;
            } else if (arr[R - 1] == arr[R]) {
                sign = 0;
                L = R;
            } else {
                sign = arr[R - 1] > arr[R] ? -1 : 1;
                L = R - 1;
            }
            maxTurbulence = Math.max(maxTurbulence, R - L + 1);
        }

        return maxTurbulence;
    }
}