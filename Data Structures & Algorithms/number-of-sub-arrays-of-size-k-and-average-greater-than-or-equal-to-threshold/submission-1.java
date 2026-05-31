class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int average = 0;
        int L = 0;
        for (int R = 0; R < arr.length; R++) {
            average += arr[R];
            if (R - L + 1 > k) {
                average -= arr[L++];
            }
            if ((R - L + 1 == k) && (average / k) >= threshold) {
                count++;
            }
        }

        return count;
    }
}