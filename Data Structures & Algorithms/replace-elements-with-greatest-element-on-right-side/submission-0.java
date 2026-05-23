class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int rightMax = arr[n - 1];
        arr[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            int cur = arr[i];
            arr[i] = rightMax;
            rightMax = Math.max(rightMax, cur);
        }

        return arr;
    }
}