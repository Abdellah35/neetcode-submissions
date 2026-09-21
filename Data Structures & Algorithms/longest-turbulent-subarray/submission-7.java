class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int L = 0, R = 1;
        int longest = 1;
        char sign = '-';

        while (R < arr.length) {
            if (sign != '>' && arr[R - 1] < arr[R]) {
                longest = Math.max(longest, R - L + 1);
                R++;
                sign = '>';
            } else if (sign != '<' && arr[R - 1] > arr[R]) {
                longest = Math.max(longest, R - L + 1);
                sign = '<';
                R++;
            } else {
                R = arr[R - 1] == arr[R] ? R + 1 : R;
                L = R - 1;
                sign = '-';
            }
        }

        return longest;
    }
}