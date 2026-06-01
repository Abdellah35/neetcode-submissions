class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int maxTurbulence = 1;
        int L = 0;

        for (int R = 1; R < arr.length; R++) {
            int c = Integer.compare(arr[R - 1], arr[R]);

            if ( c == 0) {
                L = R;
            } else if (R > 1 && c == Integer.compare(arr[R - 2], arr[R - 1])) {
                L = R - 1;
            }
            maxTurbulence = Math.max(maxTurbulence, R - L + 1);
        }

        return maxTurbulence;
    }
}